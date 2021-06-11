function saveApi(){
    let data = $('#saveForm').serializeObject();
    apiObj.saveAjax(data);
}
function deleteApi(id){
    apiObj.deleteAjax(id);
}
function updateApi(){
    let data = $('#updateForm').serializeObject();
    apiObj.updateAjax(data);
}