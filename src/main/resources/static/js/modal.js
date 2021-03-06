function entryModal(){
    if(document.querySelector(".uk-modal")){
        document.getElementById("modal-close").remove();
    }
    if(document.getElementById("entryForm") != null){
        document.getElementById("entryForm").remove();
    }
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
                button_element = '<div class="uk-text-warning uk-text-center uk-margin-bottom">既に参加申込済みです</div>'+
                                 '<button onclick="cancelSubmit()" class="uk-button uk-button-danger uk-margin-bottom" type="button">申込取消</button>';
            } else {
                button_element = '<form id="entryForm" method="POST" enctype="multipart/form-data">'+
                                    '<input id="question" class="uk-margin-small uk-input" type="text"   placeholder="事前に質問しておきたいこと">'+
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
            UIkit.notification("<span uk-icon='icon: check; ratio: 1.5'></span> 参加申込を受け付けました",{status:'success',timeout: 1500});
         })
         .catch(error =>{
             UIkit.modal().hide();
         });

}

function cancelSubmit(){
    
    axios.post('http://localhost:8080/srms/entry/cancel')
         .then(response => {
            document.getElementById("modal-close").click();
            UIkit.notification("<span uk-icon='icon: check; ratio: 1.5'></span> 参加申込を取り消しました",{status:'warning',timeout: 1500});
         })
         .catch(error =>{
             UIkit.modal().hide();
         });

}


function notification(){
    UIkit.notification("<span uk-icon='icon: check; ratio: 1.5'></span> Test",{status:'warning',timeout: 1500});
}

function editSeminar(seminarId){
    if(document.querySelector(".uk-modal")){
        document.getElementById("modal-close").remove();
    }
    if(document.getElementById("editSeminarForm") != null){
        document.getElementById("editSeminarForm").remove();
        document.getElementById("editSpeakerForm").remove();
    }
    axios
        .get("http://localhost:8080/srms/admin/editableseminar/"+seminarId)
        .then(response => {

            let table_element　=　new String();
            let numberOfSpeaker = 0;
            for (var speaker of response.data.speakers){
                numberOfSpeaker++;
                table_element += '<tr>'+
                                    '<input type="hidden" id="speakerId'+numberOfSpeaker+'" value='+speaker.speakerId+'>'+
                                    '<th><input class="uk-input" id="speakerName'+numberOfSpeaker+'" type="text" value="'+speaker.name+'"></th>'+
                                    '<th><input class="uk-input" id="speakerTitle'+numberOfSpeaker+'" type="text" value="'+speaker.theme+'"></th>'+
                                 '</tr>';
            }

            const element =  '<div uk-modal>'+
                                '<div class="uk-modal-dialog">'+
                                    '<button id="modal-close" class="uk-modal-close-default" type="button" uk-close></button>'+
                                    '<div class="uk-modal-header">'+
                                        '<h4>Details Edit</h4>'+
                                    '</div>'+
                                    '<div class="uk-modal-body">'+
                                        '<form id="editSeminarForm" method="POST" enctype="multipart/form-data">'+
                                            '<input type="hidden" id="seminarId" value='+response.data.seminar.seminarId +'>'+
                                            '<div class="uk-margin">'+
                                                '<label class="uk-form-label" for="form-horizontal-text">セミナー名</label>'+
                                                '<div class="uk-form-controls">'+
                                                    '<input class="uk-input" id="seminarTitle" type="text" value="'+response.data.seminar.title+'">'+
                                                '</div>'+
                                                '<label class="uk-form-label" for="form-horizontal-text">開催日</label>'+
                                                '<div class="uk-form-controls">'+
                                                    '<input class="uk-input" id="eventDate" type="text" value="'+response.data.seminar.eventDate+'">'+
                                                '</div>'+
                                                '<label class="uk-form-label" for="form-horizontal-text">開始時間</label>'+
                                                '<div class="uk-form-controls">'+
                                                    '<input class="uk-input" id="startedTime" type="text" value="'+response.data.seminar.startedTime+'">'+
                                                '</div>'+
                                                '<label class="uk-form-label" for="form-horizontal-text">終了時間</label>'+
                                                '<div class="uk-form-controls">'+
                                                    '<input class="uk-input" id="closedTime" type="text" value="'+response.data.seminar.closedTime+'">'+
                                                '</div>'+
                                            '</div>'+
                                        '</form>'+
                                        '<form id="editSpeakerForm" method="POST" enctype="multipart/form-data">'+
                                            '<div class="uk-margin">'+
                                                '<table class="uk-table uk-table-hover uk-table-middle uk-table-divider">'+
                                                    '<thead>'+
                                                        '<tr>'+
                                                            '<th>講演者</th>'+
                                                            '<th>タイトル</th>'+
                                                        '</tr>'+
                                                    '</thead>'+
                                                    '<tbody id="speakerList">'+
                                                        table_element+
                                                    '</tbody>'+
                                                '</table>'+
                                            '</div>'+ 
                                        '</form>'+  
                                    '</div>'+
                                    '<div class="uk-modal-footer uk-text-center">'+
                                        '<button onclick="editableInfoSubmit()" class="uk-button uk-button-primary" type="button">適用</button>'+
                                    '</div>'+
                                '</div>'+
                            '</div>';
            UIkit.modal(element).show();                  
        })

        .catch(error => {
            UIkit.modal.alert('取得失敗!')
        });
}

function editableInfoSubmit(){
    const seminarValue = {
        seminarId:document.forms.editSeminarForm.seminarId.value,
        title:document.forms.editSeminarForm.seminarTitle.value,
        eventDate:document.forms.editSeminarForm.eventDate.value,
        startedTime:document.forms.editSeminarForm.startedTime.value,
        closedTime:document.forms.editSeminarForm.closedTime.value
    }
    let speakerValue =[]
    const tableBody = document.getElementById("speakerList");

    for(var i=0, rowLen=tableBody.rows.length; i<rowLen; i++){
        const data = {
            speakerId:tableBody.rows[i].children[0].value,
            name:tableBody.rows[i].cells[0].children[0].value,
            theme:tableBody.rows[i].cells[1].children[0].value
        }
        speakerValue.push(data)
    }

    const formData = new FormData()
    formData.append('seminarValue', new Blob([JSON.stringify(seminarValue)], {type : 'application/json'}))
    formData.append('speakerValue', new Blob([JSON.stringify(speakerValue)], {type : 'application/json'}))

    axios.post('http://localhost:8080/srms/admin/applyedits', formData)
         .then(response => {
            const target = document.getElementById('detailsSpace');
            let table_element　=　new String();
            for (var speaker of response.data.speakers){
                table_element += '<tr>'+
                                    '<td>'+speaker.name+'</td>'+
                                    '<td>'+speaker.theme+'</td>'+
                                 '</tr>';
            }

            target.innerHTML = '<dt>[タイトル]</dt>'+
                                '<dd>'+response.data.seminar.title+'</dd>'+
                                '<dt>[開催日時]</dt>'+
                                '<dd>'+response.data.seminar.eventDate+' '+response.data.seminar.startedTime+'～'+response.data.seminar.closedTime+'</dd>'+
                                '<dt>[講演者・タイトル]</dt>'+
                                '<dd>'+
                                    '<table class="uk-table uk-table-divider uk-text-small uk-width-3-4">'+
                                        '<tbody>'+
                                            table_element+
                                        '</tbody>'+
                                    '</table>'+
                                '</dd>';

            document.getElementById("modal-close").click();
            UIkit.notification("<span uk-icon='icon: check; ratio: 1.5'></span> 編集内容を反映しました",{status:'success',timeout: 1500});
         })
         .catch(error =>{
             UIkit.modal().hide();
         });
}

function addSpeaker(){
    const target = document.getElementById('speakerList');
    let addElement = document.createElement("tr");
    //addElement.setAttribute("class","uk-form-controls uk-margin-small");
    addElement.innerHTML = '<th><input class="uk-input" type="text"></th>'+
                           '<th><input class="uk-input" type="text"></th>';
    target.appendChild(addElement);
}

function addSeminar(){
    if(document.querySelector(".uk-modal")){
        document.getElementById("modal-close").remove();
    }
    if(document.getElementById("addSeminarForm") != null){
        document.getElementById("addSeminarForm").remove();
        document.getElementById("addSpeakerForm").remove();
    }

    const element =  '<div uk-modal>'+
                        '<div class="uk-modal-dialog">'+
                            '<button id="modal-close" class="uk-modal-close-default" type="button" uk-close></button>'+
                            '<div class="uk-modal-header">'+
                                '<h4>新規作成</h4>'+
                            '</div>'+
                            '<div class="uk-modal-body">'+
                                '<form id="addSeminarForm" method="POST" enctype="multipart/form-data">'+
                                    '<input type="hidden" id="seminarId">'+
                                    '<div class="uk-margin">'+
                                        '<label class="uk-form-label" for="form-horizontal-text">セミナー名</label>'+
                                        '<div class="uk-form-controls">'+
                                            '<input class="uk-input" id="seminarTitle" type="text">'+
                                        '</div>'+
                                        '<label class="uk-form-label" for="form-horizontal-text">開催日</label>'+
                                        '<div class="uk-form-controls">'+
                                            '<input class="uk-input" id="eventDate" type="text">'+
                                        '</div>'+
                                        '<label class="uk-form-label" for="form-horizontal-text">開始時間</label>'+
                                        '<div class="uk-form-controls">'+
                                            '<input class="uk-input" id="startedTime" type="text">'+
                                        '</div>'+
                                        '<label class="uk-form-label" for="form-horizontal-text">終了時間</label>'+
                                        '<div class="uk-form-controls">'+
                                            '<input class="uk-input" id="closedTime" type="text">'+
                                        '</div>'+
                                    '</div>'+
                                '</form>'+
                                '<form id="addSpeakerForm" method="POST" enctype="multipart/form-data">'+
                                    '<div class="uk-margin">'+
                                        '<table class="uk-table uk-table-hover uk-table-middle uk-table-divider">'+
                                            '<thead>'+
                                                '<tr>'+
                                                    '<th>講演者</th>'+
                                                    '<th>タイトル</th>'+
                                                '</tr>'+
                                            '</thead>'+
                                            '<tbody id="speakerList">'+
                                                '<tr>'+
                                                    '<th><input class="uk-input" type="text"></th>'+
                                                    '<th><input class="uk-input" type="text"></th>'+
                                                '</tr>'+
                                                '<tr>'+
                                                    '<th><input class="uk-input" type="text"></th>'+
                                                    '<th><input class="uk-input" type="text"></th>'+
                                                '</tr>'+
                                            '</tbody>'+
                                        '</table>'+
                                        '<a onclick="addSpeaker()">講演者を追加する</a>'+
                                    '</div>'+ 
                                '</form>'+  
                            '</div>'+
                            '<div class="uk-modal-footer uk-text-center">'+
                                '<button onclick="addSeminarSubmit()" class="uk-button uk-button-primary" type="button">適用</button>'+
                            '</div>'+
                        '</div>'+
                    '</div>';
    UIkit.modal(element).show();                  
}

function addSeminarSubmit(){
    const seminarValue = {
        //seminarId:document.forms.editSeminarForm.seminarId.value,
        title:document.forms.addSeminarForm.seminarTitle.value,
        eventDate:document.forms.addSeminarForm.eventDate.value,
        startedTime:document.forms.addSeminarForm.startedTime.value,
        closedTime:document.forms.addSeminarForm.closedTime.value
    }
    let speakerValue =[]
    const tableBody = document.getElementById("speakerList");

    for(var i=0, rowLen=tableBody.rows.length; i<rowLen; i++){
        const data = {
            name:tableBody.rows[i].cells[0].children[0].value,
            theme:tableBody.rows[i].cells[1].children[0].value
        }
        speakerValue.push(data)
    }

    const formData = new FormData()
    formData.append('seminarValue', new Blob([JSON.stringify(seminarValue)], {type : 'application/json'}))
    formData.append('speakerValue', new Blob([JSON.stringify(speakerValue)], {type : 'application/json'}))

    axios.post('http://localhost:8080/srms/admin/createseminar', formData)
         .then(response => {
            // const target = document.getElementById('detailsSpace');
            // let table_element　=　new String();
            // for (var speaker of response.data.speakers){
            //     table_element += '<tr>'+
            //                         '<td>'+speaker.name+'</td>'+
            //                         '<td>'+speaker.theme+'</td>'+
            //                      '</tr>';
            // }

            // target.innerHTML = '<dt>[タイトル]</dt>'+
            //                     '<dd>'+response.data.seminar.title+'</dd>'+
            //                     '<dt>[開催日時]</dt>'+
            //                     '<dd>'+response.data.seminar.eventDate+' '+response.data.seminar.startedTime+'～'+response.data.seminar.closedTime+'</dd>'+
            //                     '<dt>[講演者・タイトル]</dt>'+
            //                     '<dd>'+
            //                         '<table class="uk-table uk-table-divider uk-text-small uk-width-3-4">'+
            //                             '<tbody>'+
            //                                 table_element+
            //                             '</tbody>'+
            //                         '</table>'+
            //                     '</dd>';

            document.getElementById("modal-close").click();
            UIkit.notification("<span uk-icon='icon: check; ratio: 1.5'></span> 作成しました",{status:'success',timeout: 1500});
         })
         .catch(error =>{
             UIkit.modal().hide();
         });
}


