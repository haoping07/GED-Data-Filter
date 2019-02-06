var fs = require('fs');
var data = fs.readFileSync('proj02test.txt', 'utf8');
data = data.split('\n');

for(var x = 0 ; x < data.length ; x++){
    data[x] = data[x].replace('\r' , '');
    data[x] = data[x].split(' ');
    data[x] = removeSpace(data[x]);
}
//console.log(data);

var level = -1;
var tag = '';
var valid = '';
var agru = '';
var pos = -1;
var out = '';

for(var x = 0 ; x < data.length ; x++){
    level = parseInt(data[x][0]);
    if(level === 0){
        if(inArr(['INDI' , 'FAM'] , data[x][data[x].length-1])){
            tag = data[x][data[x].length-1];
            pos = data[x].length-1;
            agru = '';
            for(var y = 1 ; y < data[x].length-1 ; y++){
                agru = agru + ' ' + data[x][y];
            }
        }
        else{
            tag = data[x][1];   
            pos = 1; 
            agru = '';
            for(var y = 2 ; y < data[x].length ; y++){
                agru = agru + ' ' + data[x][y];
            }
        }
    }
    else{
        tag = data[x][1];   
        pos = 1; 
        agru = '';
        for(var y = 2 ; y < data[x].length ; y++){
            agru = agru + ' ' + data[x][y];
        }
    }
    valid = checkvalid(level , tag , pos);
    out = '';
    for(var a = 0 ; a < data[x].length ; a++){
        out = out + ' ' + data[x][a];

    }
    console.log('--> ' + out)
    console.log('<-- ' + level + '|' + tag + '|' + valid + '|' + agru)
}


function checkvalid(level , tag , pos){
    if(inGroup(level , tag , pos)){
        return 'Y';
    }
    else{
        return 'N';
    }
}

function inGroup(group , tag , pos){
    G0a = ['HEAD' , 'TRLR' , 'NOTE'];
    G0b = ['INDI' , 'FAM'];
    G1 = ['NAME' , 'SEX' , 'BIRT' , 'DEAT' , 'FAMC' , 'FAMS' , 'MARR' , 'HUSB' , 'WIFE' , 'CHIL' , 'DIV'];
    G2 = ['DATE'];

    switch(group){
        case 0:
        if(inArr(G0a , tag)){
            if(pos === 1){
                return true;
            }
            else return false;
        }
        else if(inArr(G0b , tag)){
            if(pos === 1){
                return false;
            }
            else return true;
        }
        return false;

        case 1:
        return inArr(G1 , tag);

        case 2:
        return inArr(G2 , tag);

        default:
        return false;
    }
}

function inArr(arr , val){
    for(var x = 0 ; x < arr.length ; x++){
        if(arr[x] === val){
            return true;
        }
    }
    return false;
}

function removeSpace(arr){
    var out = new Array(0);
    for(var x = 0 ; x < arr.length ; x++){
        if(arr[x] != ''){
            out.push(arr[x]);
        }
    }
    return out;
}