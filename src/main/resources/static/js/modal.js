function entryModal(){
    axios
        .get("http://localhost:8080/srms/mypage/getseminar")
        .then(response => {

            let table_element　=　new String();
            let button_element = new String();
            for (var speaker of response.data.speakers){
                table_element += '<tr>'+
                                    '<td>'+speaker.startedTime+'</td>'+
                                    '<td>'+speaker.theme+'</td>'+
                                    '<td>'+speaker.name+'</td>'+
                                 '</tr>';
            }

            if(response.data.isEntered){
                button_element = '<button class="uk-button uk-button-danger" type="button">申込取消</button>';
            } else {
                button_element = '<form id="entryForm" method="POST" enctype="multipart/form-data">'+
                                    '<input id="question" class="uk-margin-small uk-input" type="text" placeholder="事前に質問しておきたいこと">'+
                                    '<input type="hidden" id="seminarId" value='+response.data.seminar.seminarId +'>'+
                                    '<button onclick="entrySubmit()" class="uk-button uk-button-primary" type="button">申し込む</button>'+
                                 '</form>';
            }

            const element =  '<div uk-modal>'+
                                '<div class="uk-modal-dialog">'+
                                    '<button id="modal-close" class="uk-modal-close-default" type="button" uk-close></button>'+
                                    '<div class="uk-modal-header">'+
                                        '<h4>'+response.data.seminar.title+'</h4>'+
                                    '</div>'+
                                    '<div class="uk-modal-body">'+
                                        '<p>タイムテーブル</p>'+
                                        '<table class="uk-table uk-table-striped">'+
                                            '<thead>'+
                                                '<tr>'+
                                                    '<th>時間</th>'+
                                                    '<th>内容</th>'+
                                                    '<th>講演者</th>'+
                                                '</tr>'+
                                            '</thead>'+
                                            '<tbody>'+
                                                table_element+
                                            '</tbody>'+
                                        '</table>'+
                                    '</div>'+
                                    '<div class="uk-modal-footer uk-text-center">'+
                                        button_element+
                                    '</div>'+
                                '</div>'+
                            '</div>';
            UIkit.modal(element).show();
        })

        .catch(error => {
            UIkit.modal.alert('取得失敗!')
        });
}

function entrySubmit(){
    const guestInfo = {
        seminarId:document.forms.entryForm.seminarId.value,
        priorQuestion:document.forms.entryForm.question.value
    }

    const formData = new FormData()
    formData.append('jsonValue', new Blob([JSON.stringify(guestInfo)], {type : 'application/json'}))

    axios.post('http://localhost:8080/srms/entry/ajaxwork', formData)
         .then(response => {
            document.getElementById("modal-close").click();
            UIkit.notification("<span uk-icon='icon: check'></span> 申し込みが完了しました",{status:'success'});
         })
         .catch(error =>{
             UIkit.modal().hide();
         });

}