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
