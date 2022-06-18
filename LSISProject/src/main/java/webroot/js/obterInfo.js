function getEquipas() {
    fetch('/getEquipas', {
        method: 'GET'
    })
    .then((res) => {
        if (res.status === 200){
            return res.json(); 
        } else {
            throw Error("Erro no servidor!");
        }
    })
    .then((data) => {
        if (data.length > 0 ) {
            document.getElementById("id_equipas");

            let li = "";
            for (let i = 0; i < data.length; i++) {
                li += '<tr><td>' + data[i].idEquipa + '</td><td>' + data[i].nomeEquipa + '</td></tr>';
            }
            document.getElementById("listaEquipas").innerHTML = li;
        }
    })
    .catch((err) => console.log(err));
}

function getCompeticoes() {
    fetch('/getCompeticoes', {
        method: 'GET'
    })
    .then((res) => {
        if (res.status === 200){
            return res.json(); 
        } else {
            throw Error("Erro no servidor!");
        }
    })
    .then((data) => {
        if (data.length > 0 ) {
            document.getElementById("id_competicoes");

            let li = "";
            for (let i = 0; i < data.length; i++) {
                li += '<tr><td>' + data[i].idCompeticao + '</td><td>' + data[i].nomeCompeticao + '</td><td>' +
                    data[i].dataCriacaoString + '</td></tr>';
            }
            document.getElementById("listaCompeticoes").innerHTML = li;
        }
    })
    .catch((err) => console.log(err));
}

function getRondas() {
    fetch('/getRondas', {
        method: 'GET'
    })
    .then((res) => {
        if (res.status === 200){
            return res.json(); 
        } else {
            throw Error("Erro no servidor!");
        }
    })
    .then((data) => {
        if (data.length > 0 ) {
            document.getElementById("id_rondas");

            let li = "";
            for (let i = 0; i < data.length; i++) {
                li += '<tr><td>' + data[i].idRonda + '</td><td>' + data[i].idCompeticao + '</td><td>' + data[i].tipoRonda + '</td></tr>';
            }
            document.getElementById("listaRondas").innerHTML = li;
        }
    })
    .catch((err) => console.log(err));
}

function getRobo() {
    fetch('/getRobos', {
        method: 'GET'
    })
            .then((res) => {
                if (res.status === 200)
                    return res.json();
                else
                    throw Error("Erro no servidor!!");
            })
            .then((data) => {
                if (data.length > 0) {
                    document.getElementById("id_Robos").style.display = 'flex';

                    let li = "";
                    for (let i = 0; i < data.length; i++) {
                        li += '<tr><td>' + data[i].idRobo + '</td><td>' + data[i].idEquipa + '</td><td>' +
                                data[i].nomeRobo + '</td><td>' + data[i].macAddress + '</td></tr>';
                    }
                    document.getElementById("listaRobots").innerHTML = li;
                }
            })
            .catch((err) => console.log(err));
}