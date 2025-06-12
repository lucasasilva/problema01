window.onload = () => {
  getData();
};

async function getData(params) {
  const url = "http://localhost:8080/retornar-tickets";
  let response = await fetch(url, {
    method: "POST",
    headers: { "Content-type": "application/json" },
    body: JSON.stringify({ mes: 4, ano: 2021 }),
  });
  const dados = await response.json();

   //criar gráfico
   const ctx = document.getElementById("grafico-clientes");
   function criarGrafico(dadosJson) {
     new Chart(ctx, {
       type: "doughnut",
       data: {
         labels: dadosJson.map(row => row.ticketsPorCliente.forEach(item => {item.cliente})),
         datasets: [
           {
             label: "# of Votes",
             data:dadosJson[0].ticketsPorCliente.map(item=> item.totalTicketsCliente),
             borderWidth: 1,
           },
         ],
       },
       options: {
         scales: {
           y: {
             beginAtZero: true,
           },
         },
       },
     });
   }
   criarGrafico(dados)
   console.log(dados[0].ticketsPorCliente[0].totalTicketsCliente)



  const elementoHTML = document.getElementById("cabecalho-tickets");

  const listaTickets = dados[0].tickets;
  if (elementoHTML) {
    //let html =
    listaTickets.forEach((ticket) => {
      document.getElementById("id").innerHTML += `${ticket.id} <br>`;
      document.getElementById("Titulo").innerHTML += `${ticket.nome}<br>`;
      document.getElementById(
        "Cliente"
      ).innerHTML += `${ticket.codCliente.nome}<br>`;
      document.getElementById("dtAbertura").innerHTML += `${ticket.dataAbertura
        .split("-")
        .reverse()
        .join("/")}<br>`;
      document.getElementById(
        "dtEncerramento"
      ).innerHTML += `${ticket.dataEncerramento
        .split("-")
        .reverse()
        .join("/")}<br>`;
      document.getElementById(
        "Modulo"
      ).innerHTML += `${ticket.codModulo.nome}<br>`;
    });
    //html += "</div>";

    //elementoHTML.innerHTML = html;

   
  } else {
    console.log("nenhum elemento chamado tickets encontrado");
  }
}
