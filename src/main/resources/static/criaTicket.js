function abrirFormulario() {
  document.getElementById("formulario-ticket").style.display = "block";
}

function fecharFormulario() {
  document.getElementById("formulario-ticket").style.display = "none";
}

document.getElementById("formTicket").addEventListener("submit", function (e) {
  e.preventDefault();

  const ticket = {
    nome: document.getElementById("titulo").value,
    codCliente: { id: parseInt(document.getElementById("clienteId").value) },
    codModulo: { id: parseInt(document.getElementById("moduloId").value) },
    dataAbertura: document.getElementById("dataAbertura").value,
    dataEncerramento: document.getElementById("dataEncerramento").value
  };

  fetch("http://localhost:8080/criar-ticket", {
    method: "POST",
    headers: { "Content-Type": "application/json" },
    body: JSON.stringify(ticket)
  })
    .then(res => {
      if (!res.ok) throw new Error("Erro ao criar ticket");
      alert("Ticket criado com sucesso!");
      fecharFormulario();
    })
    .catch(err => alert(err.message));
});
