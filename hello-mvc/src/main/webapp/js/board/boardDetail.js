/**
 * 댓글 삭제
 */
document.querySelectorAll(".comment-del-btn").forEach((btn) => {
   btn.addEventListener('click', (e) => {
       const frm = e.target.parentElement.nextElementSibling;
       // console.log(frm);
       if(confirm("댓글을 삭제하시겠습니까?")){
           frm.submit();
       }
   });
});
/**
 * 게시글 삭제
 */
document.querySelector(".del-btn").addEventListener('click', (e) => {
    const frm = document.boardDeleteFrm;
    if(confirm("게시글을 삭제하시겠습니까? ")){
        frm.submit();
    }
});
/**
 * 댓글 등록폼
 * - 이벤트 버블링을 이용해서 최상위 document객체에 submit 핸들러 연결
 * - 폼이 제출되기전 submit이벤트가 발생하고, 상위로 전파(bubbling)되서 이 핸들러를 호출
 */

document.addEventListener('submit', (e) => {
    // 정적으로 생성된 폼, 동적으로 생성된 폼 모두 적용
    if(e.target.matches("[name=boardCommentCreateFrm]")) {
        const frm = e.target;
        const memberId = frm.memberId;
        const content = frm.content;

        if(!memberId.value) {
            alert('로그인 후 댓글을 작성해주세요');
            e.preventDefault();
            return;
        }

        if(!/^(.|\n)+$/.test(content.value.trim())){
            alert('댓글 내용을 작성해주세요.');
            e.preventDefault();
            return;
        }
    }
   
});

/**
 * 답글버튼 클릭 핸들러
 */
document.querySelectorAll(".btn-reply").forEach((button) => {
    button.addEventListener('click', (e) => {
        const parentCommentId = e.target.value;
        console.log(e.target.dataset)
        const {contextPath, boardId, loginMemberId} = e.target.dataset;

        console.log(parentCommentId); // 댓글 id
        // 대댓글 입력폼
        const html = `
        <tr>
        <td colspan="4">
          <form name="boardCommentCreateFrm" action="${contextPath}/board/boardCommentCreate" method="post">
            <div class="flex items-center px-3 py-2 bg-white hover:bg-gray-50 border-b">
                <input type="hidden" name="boardId" value="${boardId}">
                <input type="hidden" name="memberId" value="${loginMemberId}">
                <input type="hidden" name="commentLevel" value="2">
                <input type="hidden" name="parentCommentId" value="${parentCommentId}">
                <textarea id="content" name="content" required rows="1" class="resize-none block mx-4 p-2.5 w-full text-sm text-gray-900 bg-white rounded-lg border border-gray-300 focus:ring-blue-500 focus:border-blue-500" placeholder="답글을 작성하세요..."></textarea>
                <button type="submit" class="inline-flex justify-center p-2 text-blue-600 rounded-full cursor-pointer hover:bg-blue-100">
                  <svg class="w-5 h-5 rotate-90 rtl:-rotate-90" aria-hidden="true" xmlns="http://www.w3.org/2000/svg" fill="currentColor" viewBox="0 0 18 20">
                      <path d="m17.914 18.594-8-18a1 1 0 0 0-1.828 0l-8 18a1 1 0 0 0 1.157 1.376L8 18.281V9a1 1 0 0 1 2 0v9.281l6.758 1.689a1 1 0 0 0 1.156-1.376Z"/>
                  </svg>
                </button>
            </div>
          </form>
        </td>
        </tr>
        `;
        const tr = e.target.parentElement.parentElement;
        console.log(tr);

        // beforebegin 이전 형제요소로 추가
        // afterbegin 첫번째 자식요소로 추가
        // beforeend 마지막 자식요소로 추가
        // afterend 다음 형제요소로 추가
        tr.insertAdjacentHTML('afterend', html);
    }, {
        once: true
    });
});
