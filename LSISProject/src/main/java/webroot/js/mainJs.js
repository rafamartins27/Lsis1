function publishToTable() {
    const nomeEquipa = document.getElementById('nomeEquipa').value;
    const classificacao = 'calculado automaticamente';
    const error = document.getElementById('error');
    error.innerHTML = (!nomeEquipa || !classificacao) ? 'Nome da equipa e classificacao sao obrigatorios.' : '';
    if (nomeEquipa && classificacao) {
        const tableElement = document.getElementById('table');
        const trElement = document.createElement('tr');
        const tbodyElement = document.createElement('tbody');
        const nameEle = document.createElement('td');
        const emailEle = document.createElement('td');
        nameEle.innerHTML = nomeEquipa;
        emailEle.innerHTML = classificacao;
        trElement.appendChild(nameEle);
        trElement.appendChild(emailEle);
        tbodyElement.appendChild(trElement);
        tableElement.appendChild(tbodyElement);
    }
}