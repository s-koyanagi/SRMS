function getSeminarInfo(seminarId){
    axios
        .get("http://localhost:8080/srms/admin/getseminar/"+seminarId)
        .then(response => {
            let target = document.getElementById('seminarDetails');
            target.innerHTML = '<h3>'+response.data.title+'</h3>';
        })
        .catch(error => {
            UIkit.modal.alert('取得失敗!')
        });
}

function addSpeaker(){
    const target = document.getElementById('addSpeakerSpace');
    let addElement = document.createElement("div");
    addElement.setAttribute("class","uk-form-controls uk-margin-small");
    addElement.innerHTML = '<input class="uk-input uk-form-width-medium" id="form-horizontal-text" type="text" placeholder="Full name">'+
                           '<input class="uk-input uk-width-1-2@l uk-margin-left" id="form-horizontal-text" type="text" placeholder="title">';

    target.appendChild(addElement);
}
