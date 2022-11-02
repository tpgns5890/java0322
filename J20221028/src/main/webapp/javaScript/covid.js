// covid.js

window.onload = function () {
    //request url.
    let url =
        'https://api.odcloud.kr/api/15077586/v1/centers?page=1&perPage=284&serviceKey=4VNFMuH4ik4UNqCYyhHAzPRjHykTJgH1b7PN8ULj9V9wiz6U2cn5wvXzeQc%2Bv66xV7h2ahHzGsQRyINVQJqQOA%3D%3D';

    fetch(url)
        .then(result => result.json()) //json -> object
        .then(showList)
        .catch(error => console.log(error));

    document.querySelector('#findBtn').addEventListener('click', findCenterList);
}

let titles = {
    id: '센터아이디',
    centerName: '센터명',
    phoneNumber: '연락처',
    lat: '위도',
    lng: '경도',

};

let data;

function showList(result) {
    //타이틀 생성부분
    makeHead();

    //body 영역 생성. 데이터 초기화
    data = result.data;

    //option 태그생성
    makeOption(data);

    let selectCity = data.filter(center => center.sido == '서울특별시');
    makeList(selectCity);
}
function makeOption(ary=[]){
    //select태그생성.
    let sidoAry = []; //['서울특별시', '대전광역시',...]
    data.forEach(center => {
        //data에 있는 센터정보와 sidoAry에 있는 센터정보를 비교
        //sidoAry에 값이 있으면 no, sidoAry에 값이 없으면 추가
        if(sidoAry.indexOf(center.sido) == -1){
            sidoAry.push(center.sido);
        }
    });
    let cityList = document.getElementById('city');
    sidoAry.forEach(sido =>{
        let option = document.createElement('option');
        option.value =sido;
        option.textContent = sido;
        cityList.append(option);
    })
}

function findCenterList() {
    let searchKey = document.querySelector('#city').value;
    let searchAry = data.filter(center => center.sido == searchKey);
    makeList(searchAry);
}

function makeList(ary = []) {
    //화면에 tr이 있으면 tr삭제.
    document.querySelectorAll('#list>tr').forEach(tr => tr.remove());
    let list = document.getElementById('list');
    ary.forEach(center => {
        list.append(makeTr(center));
    });

    //
    document.querySelectorAll('#list>tr').forEach((tr,idx)=>{
        let td = document.createElement('td');
        td.textContent = idx + 1;
        tr.prepend(td); //append():마지막 위치에 추가. prepend():처음위치에 추가.
    });
}

//makeTr
function makeTr(row = {}) {
    let tr = document.createElement('tr');
    tr.setAttribute('lng', row.lng);
    tr.setAttribute('lat', row.lat);
    tr.setAttribute('facilityName', row.facilityName);
    tr.addEventListener('click', openInfoWindow);

    //td 생성
    for (let field in titles) {
        let td = document.createElement('td');
        let txt = document.createTextNode(row[field]);
        td.appendChild(txt);
        tr.appendChild(td);
    }
    return tr;
}

function openInfoWindow(e){
    let lng = e.target.parentElement.getAttribute('lng');
    let lat = e.target.parentElement.getAttribute('lat');
    let facilityName = e.target.parentElement.getAttribute('facilityName');
   
    window.location.href = 'infoWindow.html?facilityName='+facilityName+'&x='+lng+'&y='+lat;
}

//makeHead
function makeHead() {
    //타이틀.
    let tr = document.createElement('tr');
    let th = document.createElement('th');
    th.textContent = '순번';
    tr.appendChild(th);
    for (let title in titles) {
        let th = document.createElement('th');
        let txt = document.createTextNode(titles[title]);
        th.appendChild(txt);
        tr.appendChild(th);
    }
    document.getElementById('title').append(tr);
}