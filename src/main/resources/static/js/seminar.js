function getSeminarInfo(seminarId){
    axios
        .get("http://localhost:8080/srms/admin/getseminar/"+seminarId)
        .then(response => {
            const element = '<h3>'+response.data.seminarDTO.title+'</h3>';
            let target = document.getElementById('seminarDetails');
            target.innerHTML(element);
        })
        .catch(error => {
            UIkit.modal.alert('取得失敗!')
        });
}
