fetch('./MemberListServlet')
    .then(result => result.json())
    .then(listShow)
    .catch(error => console.error(error));

function listShow(data = []) {
    data.forEach(member => {
        let userGroup =[];
        if(member.responsibility =='user'){
            userGroup.push(member);
            console.log(userGroup);
        }
    })
    // data.filter(member => member.responsibility == 'user').map(member => {
    //     let userGroup = {
    //         g_id: member.id,
    //         g_name: member.name,
    //         g_mail: member.email,
    //         g_resp: member.responsibility
    //     }
    //     return userGroup;
    // }).forEach(userGroup => console.log(userGroup));
}