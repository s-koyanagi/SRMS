function entryModal(){
    axios
        .get("http://localhost:8080/srms/mypage/getseminar")
        .then(response => {

            let table_element　=　new String();
            for (var speaker of response.data.speakers){
                table_element += '<tr>'+
                                    '<td>'+speaker.startedTime+'</td>'+
                                    '<td>'+speaker.theme+'</td>'+
                                    '<td>'+speaker.name+'</td>'+
                                 '</tr>';
            }
            const element =  '<div uk-modal>'+
                                '<div class="uk-modal-dialog">'+
                                    '<button class="uk-modal-close-default" type="button" uk-close></button>'+
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
                                    '<div class="uk-modal-footer uk-text-right">'+
                                        '<button class="uk-button uk-button-primary" type="button">申し込む</button>'+
                                        '<button class="uk-button uk-button-danger" type="button">申込取消</button>'+
                                    '</div>'+
                                '</div>'+
                            '</div>';
            UIkit.modal(element).show();
            //console.log(response.data);
        })

        .catch(error => {
            UIkit.modal.alert('取得失敗!')
        });
}
