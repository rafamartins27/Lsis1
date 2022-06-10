function publishInfo() {
    const nomeEquipa = document.getElementById('nomeEquipa').value;
    const nomeCompeticao = document.getElementById('nomeCompeticao').value;
    const nomeRonda = document.getElementById('nomeRonda').value;
    const nomeClassificacao = 'calculado automaticamente';
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