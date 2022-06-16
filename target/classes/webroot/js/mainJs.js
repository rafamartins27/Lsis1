function publishInfo() {
    const nomeEquipa = document.getElementById('equipa_nome').value;
    const nomeCompeticao = document.getElementById('comp_nome').value;
    const nomeRonda = document.getElementById('ronda_nome').value;
    const nomeClassificacao = 'calculado automaticamente';
    localStorage.setItem('Ronda',nomeRonda);
    localStorage.setItem('Equipa',nomeEquipa);
    localStorage.setItem('Competicao',nomeCompeticao);

    console.log(localStorage);

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
    const nomeJuri = document.getElementById('juri_nome').value;
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
}

function getDados(){
    console.log(localStorage);
    const competicao = localStorage.getItem('Competicao');
    const ronda = localStorage.getItem('Ronda');
    const equipa = localStorage.getItem('Equipa');

    document.getElementById('competicao').innerHTML = competicao;
    document.getElementById('ronda').innerHTML = ronda;
    document.getElementById('equipa_nome').innerHTML = equipa;

}

function submitFormJuri(){
    let formJuri = document.getElementById("registarJuri");
    let formData = new FormData(formJuri);

    fetch('/registarJuri', {method: 'POST', body: formData})
        .then((res) => {
            if(res.status === 200) {
                alert("Success!");
                return res.json();
            }
            else throw Error("Server error!!");})
        .catch((err) => console.log(err));
}

function submitFormComp() {
    let formComp = document.getElementById("formComp");
    let formData = new FormData(formComp);

    fetch('/registarCompeticao', {method: 'POST', body: formData})
        .then((res) => {
            if(res.status === 200) {
                alert("Success!");
                return res.json();
            }
            else throw Error("Server error!!");})
        .catch((err) => console.log(err));
}

function submitFormRonda() {
    let formRonda = document.getElementById("formRonda");
    let formData = new FormData(formRonda);

    fetch('/registarRonda', {method: 'POST', body: formData})
        .then((res) => {
            if(res.status === 200) {
                alert("Success!");
                return res.json();
            }
            else throw Error("Server error!!");})
        .catch((err) => console.log(err));

}

function submitFormEquipa() {
    let formEquipa = document.getElementById("formEquipa");
    let formData = new FormData(formEquipa);

    fetch('/registarEquipa', {method: 'POST', body: formData})
        .then((res) => {
            if(res.status === 200) {
                alert("Success!");
                return res.json();
            }
            else throw Error("Server error!!");})
        .catch((err) => console.log(err));
}

function submitFormRobo() {
    let formRobo = document.getElementById("formRobo");
    let formData = new FormData(formRobo);

    fetch('/registarRobo', {method: 'POST', body: formData})
        .then((res) => {
            if(res.status === 200) {
                alert("Success!");
                return res.json();
            }
            else throw Error("Server error!!");})
        .catch((err) => console.log(err));
}

