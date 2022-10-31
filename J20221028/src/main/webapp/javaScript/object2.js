/**
 * object2.js
 */

document.addEventListener('DOMContentLoaded', function() {
	//document.getElementById('show').innerHTML = '<p>Hello, World</p>';
	let data = `[{"id":1,"first_name":"Lou","last_name":"Catteroll","email":"lcatteroll0@topsy.com","gender":"Male","salary":8930},
{"id":2,"first_name":"Liz","last_name":"Maven","email":"lmaven1@e-recht24.de","gender":"Female","salary":2145},
{"id":3,"first_name":"Marion","last_name":"Sawney","email":"msawney2@qq.com","gender":"Male","salary":3978},
{"id":4,"first_name":"Clemmie","last_name":"Vanni","email":"cvanni3@ft.com","gender":"Male","salary":3688},
{"id":5,"first_name":"Kissie","last_name":"Conen","email":"kconen4@slate.com","gender":"Female","salary":7045},
{"id":6,"first_name":"Rodrique","last_name":"Tabard","email":"rtabard5@about.com","gender":"Male","salary":2257},
{"id":7,"first_name":"Darnell","last_name":"Burbidge","email":"dburbidge6@unblog.fr","gender":"Male","salary":8891},
{"id":8,"first_name":"Sanders","last_name":"Stoffersen","email":"sstoffersen7@mapquest.com","gender":"Male","salary":6839},
{"id":9,"first_name":"Lara","last_name":"Rosedale","email":"lrosedale8@redcross.org","gender":"Female","salary":5453},
{"id":10,"first_name":"Malorie","last_name":"Antyshev","email":"mantyshev9@examiner.com","gender":"Female","salary":4922}]`;

//json타입 => javascript 오브젝트

let result = JSON.parse(data);
console.log(result);

// for (String str : personList) {}
// <ul><li>obj</li><li>obj</li><li>obj</li><li>obj</li></ul>
// <div id = "show"></div>
const fields = ['id', 'first_name', 'email', 'salary'];

let tabTag = document.createElement('table');

for(row of result){
	tabTag.appendChild(makeTab(row));	
}
document.getElementById('show').appendChild(tabTag);

function makeTab(obj){
	let trTag = document.createElement('tr');
	let tdTag = document.createElement('td');
	trTag.appendChild(tdTag);
	let str = '';
	for(field of fields){
		str += `${field}:${obj[field]} `;
	}
	let txt = document.createTextNode(str);
	tdTag.appendChild(txt);
	
	return trTag;
}

function makeList(obj){
	let liTag = document.createElement('li');
	let str ='';
	for(field of fields){
		str += `${field}:${obj[field]} `;
	}
	let txt = document.createTextNode(str);
	liTag.appendChild(txt);
	
	return liTag;
}

});
