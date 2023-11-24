// Call the dataTables jQuery plugin
$(document).ready(function() {
    cargarUsuarios();
  $('#usuarioTable').DataTable();
});



async function cargarUsuarios(){
  const resquest = await fetch('usuario', {
    method: 'GET',
    headers: {
      'Accept': 'application/json',
      'Content-Type': 'application/json'
    },

  });
  const usuarios = await resquest.json();

  let listadoUsuariosHtml='';

  for(let usuario of usuarios){

    let usuarioHtml = `<tr>
                        <td>${usuario.id}</td>
                        <td>${usuario.nombre}</td>
                        <td>${usuario.apellido}</td>
                        <td>${usuario.telefono==null? '-':usuario.telefono }</td>
                        <td>${usuario.email}</td>
                        <td>
                            <a href="#" onclick="borrarUsuario(${usuario.id})" class="btn btn-danger btn-circle btn-sm">
                                <i class="fas fa-trash"></i>
                            </a>
                        </td>
                    </tr>
                    `
    listadoUsuariosHtml+=usuarioHtml;
  }

  document.querySelector("#usuarioTable tbody").outerHTML=listadoUsuariosHtml;
}



async function borrarUsuario(id){
    if(!confirm('Desea eliminar el usuario con el id'+ id)){
        return;
    }

    const resquest = await fetch('usuario/'+id, {
        method: 'DELETE',
        headers: {
          'Accept': 'application/json',
          'Content-Type': 'application/json'
        },
    });
    location.reload();
}

