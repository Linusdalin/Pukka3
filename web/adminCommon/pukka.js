/*****************************************************************''
 *
 *
 *              Pukka3 BO javascript functionality
 *
 */


$(document).ready(function() {


    /*********************************************************
     *
     *          launch dynamic modal content
     *
     *          The modal content is responsible for the header and footer
     *
     *
     *          Example launches:
     *
     *          <button class="btn btn-primary btn-lg" data-toggle="modal" data-target="#myModal" href="modalTest.html">
     *          <a href="modalTest.html" data-toggle="modal" data-target="#myModal">Modal link</a>
     *
     *
     */


    $('[data-toggle="modal"]').click(function(e) {

        e.preventDefault();

        // Get the href data
        var url = $(this).attr('href');

        $.ajax({
             async: false,
             type: 'GET',
             url: url,
             success: function(data) {

                 $('#pukkaModal').html(data);
             }
        });


    });
});