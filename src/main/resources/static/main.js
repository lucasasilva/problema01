window.onload = () => {
  getData();
};

//captura o mês e o ano
let body = null;
document.getElementById("mesAno").addEventListener("change", function() {
  const [ano, mes] = this.value.split("-");
  const body  = {
    mes: parseInt(mes),
    ano: parseInt(ano)
  }
  console.log(JSON.stringify(body));
})
console.log(body)

//requisição da API
async function getData(body) {
  const url = "http://localhost:8080/retornar-tickets";
  let response = await fetch(url, {
    method: "POST",
    headers: { "Content-type": "application/json" },
    body: JSON.stringify({ mes: 3, ano: 2021 }),
  });
  const dados = await response.json();
  //--------------------------------------------------------

  //criar gráfico clientes
  const clientesGrafico = document.getElementById("grafico-clientes");
  function criarGraficoClientes(dadosJson) {
    new Chart(clientesGrafico, {
      type: "doughnut",
      data: {
        labels: dadosJson[0].ticketsPorCliente.map((item) => item.cliente.nome),
        datasets: [
          {
            label: "Tickes por cliente",
            data: dadosJson[0].ticketsPorCliente.map(
              (item) => item.totalTicketsCliente
            ),
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
  criarGraficoClientes(dados);
  console.log(dados[0].ticketsPorCliente[0].cliente);
  //------------------------------------------------------------------
  //criar gráfico modulos
  const modulosGrafico = document.getElementById("grafico-modulos");
  function criarGraficoModulos(dadosJson) {
    new Chart(modulosGrafico, {
      type: "doughnut",
      data: {
        labels: dadosJson[0].ticketsPorModulo.map((item) => item.modulo.nome),
        datasets: [
          {
            label: "Tickes por Modulo",
            data: dadosJson[0].ticketsPorModulo.map(
              (item) => item.qtdTicketsMes
            ),
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
  criarGraficoModulos(dados);

  //Criar lista de tickets
  const containerTickets = document.getElementById("tickets");
  const listaTickets = dados[0].tickets;

  listaTickets.forEach((ticket) => {
    const linha = document.createElement("div");
    linha.classList.add("linha-ticket"); // para estilizar depois

    linha.innerHTML = `
    <div class="coluna">${ticket.id}</div>
    <div class="coluna">${ticket.nome}</div>
    <div class="coluna">${ticket.codCliente.nome}</div>
    <div class="coluna">${formatarData(ticket.dataAbertura)}</div>
    <div class="coluna">${formatarData(ticket.dataEncerramento)}</div>
    <div class="coluna">${ticket.codModulo.nome}</div>
  `;

    containerTickets.appendChild(linha);
  });

  // formata datas 
  function formatarData(dataISO) {
    return dataISO.split("-").reverse().join("/");
  }
}
