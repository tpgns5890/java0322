document.querySelector('#addBtn').addEventListener('click', addList)

function addList(){
    let input = document.querySelector("#input").value;
    let li =document.createElement('li');
    let p = document.createElement('p').textContent=input;
    let span = document.createElement('span');
    span.textContent = 'X';
    li.append(p);
    li.append(span);
    ul.append(li);
    
    span.addEventListener('click', function(){
        this.parentElement.remove();
    })
}