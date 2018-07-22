$(document).ready(function () {
    $.ajax({
        type: 'post',
        url: '../motorSearch/searchMotor',
        dataType:"json",
        success: function (result) {
  //          alert(JSON.stringify(result));
            var totalNum = result.length;
            if(totalNum == 0){
                alert("无电动葫芦数据记录");
            }
            var allData = result;
    //        alert(totalNum);
            $('#电动葫芦记录').html("");
            for(var i = 0;i<totalNum;i++){
                var rowData = allData[i];
      //          alert(JSON.stringify(rowData));
                var newRow = '<tr id="option" '+i+'><td>'+ rowData.id +'</td>'
                    + '<td >' +rowData.manufacturer+ '</td>'
                    + '<td >' +rowData.pattern+ '</td>'
                    + '<td >' +rowData.testNum+ '</td>'
                    + '<td >' +rowData.avgEfficiency+ '</td></tr>'
                $('#电动葫芦记录').append(newRow);
            }

        }

    })
});

function showMotorData() {
 //   alert("cousuo");
    var motorid = $("#motorid").val();
    $.ajax({
        type: 'post',
        url: '../motorSearch/searchMotorById',
        data:{
            motorId : motorid
        },
        dataType:"json",
        success: function (data) {
 //           alert("开始搜索");
  //          alert(JSON.stringify(data));
             if(data.id == null){
                 // $('#t tbody').html("");
                 $('#电动葫芦记录').html("");
                 alertWindow("无电动葫芦数据记录","error");
            }else {
            $('#电动葫芦记录').html("");
  //          alert(JSON.stringify(data));
            var newRow = '<tr id="option" ><td>'+ data.id +'</td>'
                + '<td >' +data.manufacturer+ '</td>'
                + '<td >' +data.pattern+ '</td>'
                + '<td >' +data.testNum+ '</td>'
                + '<td >' +data.avgEfficiency+ '</td></tr>'
            $('#电动葫芦记录').append(newRow);
            }
        }

    })

}