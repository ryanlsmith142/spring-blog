document.getElementById("openModal").addEventListener("click", function() {

    document.getElementById('modal').style.display = "block";

    let currentPostId = document.getElementById("postId").value;
    let titleValue = document.getElementById("individualTitle").textContent;
    let bodyValue = document.getElementById("individualBody").textContent;
    let hiddenInput = `<input type="hidden" name="id" value=${currentPostId}>`;
    document.getElementById('modalTitle').value = titleValue;
    document.getElementById('modalBody').value = bodyValue;
    document.getElementById('modalForm').setAttribute("action", `/posts/${currentPostId}/edit`);
    document.getElementById("saveChanges").innerHTML = hiddenInput;
    return currentPostId;
}); // event listener



