        function closeWindow() {
            close();
        }

        function showAddBookModal(page) {
                 $(".modal-body").empty();
                 $(".modal-body").load("/books/add?page="+page);
            }

        function showEditBookModal(id,page) {
                 $('#titleLabelAddEdit').text("Edit");
                 $(".modal-body").empty();
                 $(".modal-body").load("/books/edit?id="+id+"&page="+page);
        }

        function showEditParameterModal(id) {
             $(".modal-body").empty();
             $(".modal-body").load("/admin/edit?id="+id);
        }

        function showDeleteBookModal(id) {
             $(".modal-body").empty();
             $(".modal-body").load("/books/delete/"+id);
        }

            function showEditBookModalInUserDetails(id,ownerId) {
                $('#titleLabelDelete').text("Edit");
                $(".modal-body").empty();
                $(".modal-body").load("/users/details/bookEdit?id="+id+"&ownerId="+ownerId);
            }

            $(function() {
                   /*  Submit form using Ajax */
                   $('button[name=submitEditBookButton]').click(function(e) {

                      //Prevent default submission of form
                      e.preventDefault();

                      //Remove all errors
                      $('.error').remove();

                      $.post({
                         url : '/books/edit',
                         data : $('form[name=editBookForm]').serialize(),
                         success : function(res) {

                            if(res.validated){
                               $('#addEditBookModal').hide();
                               $('.modal-backdrop').hide();
                               $(location).attr('href', '/books/page/'+document.forms["editBookForm"]["page"].value)

                            }else{
                              //Set error messages
                              $.each(res.errorMessages,function(key,valueList){
                                  $.each(valueList, function( index, value ) {
                                    $('input[name='+key+']').after('<span class="error">'+value+'</br></span>');
                                  });
                              });
                            }
                         }
                      })
                   });
                });

            $(function() {
                /*  Submit form using Ajax */
                $('button[name=submitAddBookButton]').click(function(e) {

                //Prevent default submission of form
                e.preventDefault();

                //Remove all errors
                $('.error').remove();

                $.post({
                url : '/books/add',
                data : $('form[name=addBookForm]').serialize(),
                success : function(res) {

                    if(res.validated){
                        $('#addEditBookModal').hide();
                        $('.modal-backdrop').hide();
                        $(location).attr('href', '/books/page/'+document.forms["addBookForm"]["page"].value)

                    }else{
                        //Set error messages
                        $.each(res.errorMessages,function(key,valueList){
                            $.each(valueList, function( index, value ) {
                                $('input[name='+key+']').after('<span class="error">'+value+'</br></span>');
                            });
                        });
                    }
                }
            })
            });
            });

$(function() {
    /*  Submit form using Ajax */
    $('button[name=submitEditBookInDetailsButton]').click(function(e) {

    //Prevent default submission of form
    e.preventDefault();

    //Remove all errors
    $('.error').remove();

    $.post({
    url : '/users/details/bookEdit',
    data : $('form[name=editBookFormDetails]').serialize(),
    success : function(res) {

    if(res.validated){
        $('#deleteModal').hide();
        $('.modal-backdrop').hide();
        $(location).attr('href', '/users/details/'+document.forms["editBookFormDetails"]["ownerId"].value)

    }else{
        //Set error messages
        $.each(res.errorMessages,function(key,valueList){
            $.each(valueList, function( index, value ) {
                 $('input[name='+key+']').after('<span class="error">'+value+'</br></span>');
            });
        });
    }
    }
    })
    });
});
