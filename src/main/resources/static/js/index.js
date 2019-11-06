const editMovieClickEvent = () => {

    //returns an HTML collection of all edit-buttons on page
    let editButtons = document.getElementsByClassName("openModal");

    //loops through html collection stored in editButtons var and adds an open modal event listener.
    for(let i = 0; i < editButtons.length; i++) {

            editButtons[i].addEventListener("click", function() {

            document.getElementById('modal').style.display = "block";

            let currentMovieId = editButtons[i].id;

            let hiddenInput = `<input type="hidden" name="id" value=${currentMovieId}>`;


            document.getElementById("saveChanges").innerHTML = hiddenInput;
            return currentMovieId;
        }); // event listener
    } //for
}; //editMovieClickEvent()

editMovieClickEvent();

