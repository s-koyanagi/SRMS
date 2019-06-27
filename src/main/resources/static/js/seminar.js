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
    let target = document.getElementById('addSpeakerSpace');
    target.innerHTML = '<input class="uk-input uk-form-width-medium" id="form-horizontal-text" type="text" placeholder="Full name">'+
                       '<input class="uk-input uk-form-width-large uk-margin-left" id="form-horizontal-text" type="text" placeholder="title">'+
                       '<div id="addSpeakerSpace" class="uk-form-controls uk-margin-small">'+
                       '</div>'
}
