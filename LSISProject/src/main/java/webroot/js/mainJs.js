function publishInfo() {
    const nomeEquipa = document.getElementById('nomeEquipa').value;
    const nomeCompeticao = document.getElementById('nomeCompeticao').value;
    const nomeRonda = document.getElementById('nomeRonda').value;
    const nomeClassificacao = 'calculado automaticamente';
    localStorage.setItem('Ronda',nomeRonda);
    localStorage.setItem('Equipa',nomeEquipa);
    localStorage.setItem('Competicao',nomeCompeticao);


    const rond = JSON.parse( localStorage.getItem('Ronda') );
    console.log(rond);
    const eqi = JSON.parse( localStorage.getItem('Equipa') );
    console.log(eqi);
    const cp = JSON.parse( localStorage.getItem('Competicao') );
    console.log(cp);

    const error = document.getElementById('error');
    error.innerHTML = (!nomeEquipa || !nomeClassificacao || !nomeCompeticao || !nomeRonda) ? 'Todos os campos são obrigatórios.' : '';
    if (nomeEquipa && nomeClassificacao && nomeCompeticao && nomeRonda) {
        const tableElement = document.getElementById('table');
        const trElement = document.createElement('tr');
        const tbodyElement = document.createElement('tbody');
        const equipa = document.createElement('td');
        const classificacao = document.createElement('td');
        equipa.innerHTML = nomeEquipa;
        classificacao.innerHTML = nomeClassificacao;
        trElement.appendChild(equipa);
        trElement.appendChild(classificacao);
        tbodyElement.appendChild(trElement);
        tableElement.appendChild(tbodyElement);

        const labelCompeticao = document.getElementById('competicao');
        const labelRonda = document.getElementById('ronda');
        labelCompeticao.innerHTML = nomeCompeticao;
        labelRonda.innerHTML = nomeRonda;
    }
}

function tableJuri() {
    const nomeJuri = document.getElementById('nomeJuri').value;
    const error = document.getElementById('errorJuri');
    error.innerHTML = (!nomeJuri) ? 'O campo é obrigatório.' : '';
    if (nomeJuri) {
        const tableElement = document.getElementById('tableJuri');
        const trElement = document.createElement('tr');
        const tbodyElement = document.createElement('tbody');
        const juri = document.createElement('td');
        juri.innerHTML = nomeJuri;
        trElement.appendChild(juri);
        tbodyElement.appendChild(trElement);
        tableElement.appendChild(tbodyElement);
    }

function showVal(){
document.getElementById("valBox").innerHTML=newVal;

}
function getDados(){
const ron = JSON.parse( localStorage.getItem('Ronda') );
document.getElementById("competicao").innerHTML = localStorage.getItem("Competicao  ");


}



}