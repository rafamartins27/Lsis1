function submitForm() {
    let form = document.getElementById("form");
    let formData = new FormData(form);

    fetch('/registarCompeticao', {method: 'POST', body: formData})
        .then((res) => {
            if(res.status === 200) {
                alert("Success!");
                return res.json();
            }
            else throw Error("Server error!!");})
        .catch((err) => console.log(err));
    }