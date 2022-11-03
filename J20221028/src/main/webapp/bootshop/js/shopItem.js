//shopItem.js

fetch('../ShopItemListServlet')
.then(result => result.json())
.then(itemListShow)
.catch(err => console.error(err));


function itemListShow(result) {
    result.forEach(item => {
        makeItemDiv(item);
    });
}

function makeItemDiv(item = {}) {
    
    let template = document.querySelector('#template>div');
    let good = template.cloneNode(true);
    good.querySelector('h5').textContent = item.itemName;
    good.querySelector('img.card-img-top').src = '../images/' + item.image;
    good.querySelector('span.text-muted').textContent = item.originPrice;
    good.querySelector('span.text-muted').nextSibling.textContent = ' > ' + item.salePrice;
    
    //review
    let review = item.likeIt; // 4.5
    let a = Math.floor(review); //온쪽.
    let b = review - a;; //0 or .5
    let c = Math.floor(5 - review);
    for (let i = 0; i < a; i++) {
        let div = document.createElement('div');
        div.className = 'bi-star-fill';
        // div.setAttribute('class', 'bi-star-fill');
        good.querySelector('div.d-flex').append(div);
    }
    if (b) {
        let div = document.createElement('div');
        div.className = 'bi-star-half';
        good.querySelector('div.d-flex').append(div);
    }
    if (c >= 1) {
        for (let i = 0; i < c; i++) {
            let div = document.createElement('div');
            div.className = 'bi-star';
            good.querySelector('div.d-flex').append(div);
        }
    }
    
    //목록
    let parent = document.querySelector('section.py-5>div>div');
    parent.append(good);

    good.querySelector('.btn').addEventListener('click', addCart);
    
    function addCart(){
        let i =Number(document.querySelector('span.badge').textContent)+1;
        document.querySelector('span.badge').textContent=i;
        
    }
    

}