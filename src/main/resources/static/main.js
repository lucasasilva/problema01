window.onload = () => {
  getData();
};

async function getData(params) {
  const url = "http://localhost:8080/retornar-tickets";
  let response = 0;
  response = await fetch(url, {
    method: "POST",
    headers: { "Content-type": "application/json" },
    body: JSON.stringify({ mes: 4, ano: 2021 }),
  });
  const dados = await response.json();

  const elementoHTML = document.querySelector("#tickets");

  const listaTickets = dados[0].tickets;
  if (elementoHTML) {
    let html = "<ul>";
    listaTickets.forEach(ticket => {
      html += `
            <li>
            id: ${ticket.id}  
            Nome: ${ticket.nome}
            </li>
            `;
    });
    html += "</ul>";

    elementoHTML.innerHTML = html;
  }else{
    console.log("nenhum elemento chamado tickets encontrado")
  }
}
