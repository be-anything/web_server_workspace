/**
 * submit 버튼을 눌러 submit 이벤트가 발생하지만, 
 * 폼제출(동기적)이 아닌 비동기적으로 요청처리
 *
 * 비동기 파일 업로드
 * - form(enctype=muitipart/form-data) 에 상응하는 jqeury.ajax 설정
 *     FormData 객체 생성
 *      - contextType : false
 *      - processData : fales
 *
 */
document.celebRegisterFrm.addEventListener('submit', (e) => {
    // 동기적 제출을 막음
    e.preventDefault();

    const frm = e.target;
    const frmData = new FormData(frm); // inpur태그로 사용자입력값 모두 등록
    $.ajax({
        url: `${contextPath}/json/celeb/register`,
        method: 'post',
        data: frmData,
        contentType : false, // 기본값 application/x-www-form-urlencoded
        processData: false,
        success(response) {
            const {msg} = response;
            alert(msg);
        },
        complete() {
            frm.reset();
        }
    });
});


document.querySelector("#btn-celeb-search").addEventListener('click', () => {
    const frm = document.celebSearchFrm;
    const id = frm.id;

    $.ajax({
        url: `${contextPath}/json/celeb/findById`,
        data:  {
            id : id.value
        },
        success(celeb) {
            if(celeb){
                const {id, name, profile, type} = celeb;
                const table = document.querySelector("table#celeb");
                table.querySelector(".celeb-id").innerHTML = id;
                table.querySelector(".celeb-name").innerHTML = name;
                table.querySelector(".celeb-profile").innerHTML = `<img src="${contextPath}/images/celeb/${celeb.profile}" alt="">`;
                table.querySelector(".celeb-type").innerHTML = type;
            }
            else {
                alert("해당하는 Celeb이 없습니다. 😥");
            }
        },
        complete() {
            document.celebSearchFrm.reset();
        }
    });
});

document.querySelector("#btn-celeb").addEventListener('click', ()=>{
   $.ajax({
       url: `${contextPath}/json/celeb/findAll`,
       success(celebs){
           // 응답받은 json 데이터를 파싱(JSON.parse) 후 js객체로 반환해준다.
           console.log(celebs);
           const tbody = document.querySelector("#celebs tbody");
            tbody.innerHTML = '';

           celebs.forEach(({id, profile, name, type}) => {
                tbody.innerHTML += `<tr>
               <td>${id}</td>
               <td><img src="${contextPath}/images/celeb/${profile}" alt=""></td>
               <td>${name}</td>
               <td>${type}</td>
               <td><button>수정</button></td>
               <td><button>삭제</button></td>
               </tr>`
           })
       }
   })
});

document.celebSearchFrm.addEventListener('submit', (e) => {
    e.preventDefault();
});


