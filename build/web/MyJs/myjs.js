// Example starter JavaScript for disabling form submissions if there are invalid fields
(function () {
    'use strict';
    window.addEventListener('load', function () {
        // Fetch all the forms we want to apply custom Bootstrap validation styles to
        var forms = document.getElementsByClassName('needs-validation');
        // Loop over them and prevent submission
        var validation = Array.prototype.filter.call(forms, function (form) {
            form.addEventListener('submit', function (event) {
                if (form.checkValidity() === false) {
                    event.preventDefault();
                    event.stopPropagation();
                }
                form.classList.add('was-validated');
            }, false);
        });
    }, false);
})();

$(document).ready(function () {
    $(".btn").attr("disabled", false);
});

//Fetching District From State Start

$('#state').on('change', function () {
    let stateId = $(this).find('option:selected').attr('data-othervalue');
    $.ajax({
        type: 'POST',
        url: "fetchDistrict.jsp",
        data: {stateId: stateId},
        dataType: 'HTML',
        success: function (data) {
            $('#district').html(data);
        }, error: function (jqXHR) {

        }
    });
});

//Fetching District From State Stop

//Validation Start
var photoSize = false;
var photoType = false;
var signatureSize = false;
var signatureType = false;
var _validFileExtensions = [".jpg", ".jpeg", ".png"];
var photo = document.getElementById("photo");
function ValidatePhoto(oInput) {
    if (oInput.type == "file") {
        var sFileName = oInput.value;
        if (sFileName.length > 0) {
            var blnValid = false;
            for (var j = 0; j < _validFileExtensions.length; j++) {
                var sCurExtension = _validFileExtensions[j];
                if (sFileName.substr(sFileName.length - sCurExtension.length, sCurExtension.length).toLowerCase() == sCurExtension.toLowerCase()) {
                    blnValid = true;
                    break;
                }
            }
            if (!blnValid) {
                alert("Photo Must Be In JPG,JPEG or PNG Format");
                photo.setCustomValidity("Photo Must Be In JPG,JPEG or PNG Format");
                document.getElementById('photoMsg').innerHTML = "Photo Must Be In JPG,JPEG or PNG Format";
//                oInput.value = "";
                return false;
            } else {
                photo.setCustomValidity("");
                document.getElementById('photoMsg').innerHTML = "";
                photoType = true;
                return true;
            }
        }
    }
    return true;
}
var signature = document.getElementById("signature");
function ValidateSignature(oInput) {
    if (oInput.type == "file") {
        var sFileName = oInput.value;
        if (sFileName.length > 0) {
            var blnValid = false;
            for (var j = 0; j < _validFileExtensions.length; j++) {
                var sCurExtension = _validFileExtensions[j];
                if (sFileName.substr(sFileName.length - sCurExtension.length, sCurExtension.length).toLowerCase() == sCurExtension.toLowerCase()) {
                    blnValid = true;
                    break;
                }
            }
            if (!blnValid) {
                signature.setCustomValidity("Signature Must Be In JPG,JPEG or PNG Format");
                document.getElementById('signatureMsg').innerHTML = "Signature Must Be In JPG,JPEG or PNG Format";
//                oInput.value = "";
                return false;
            } else {
                signature.setCustomValidity("");
                document.getElementById('signatureMsg').innerHTML = "";
                signatureType = true;
                return true;
            }
        }
    }
    return true;
}

$('#photo').on('change', function () {

    let size = (this.files[0].size / 1024).toFixed(2);  //Change the file size in byte to
    if (size > 200 || size < 10) {
        if (size > 1024) {
            size = (size / 1024).toFixed(2);
            size = size + " MB";
        } else if (size >= 1 && size < 10) {
            size = size + " KB";
        } else {
            size = (size * 1024).toFixed(2);
            size = size + " Byte";
        }
        photo.setCustomValidity("<br>Photograph Size Must Be 10 KB to 200 KB");
        document.getElementById('photoMsg').innerHTML = "Your Photograph Size is:" + size + "<br>Photograph Size Must Be 10 KB to 200 KB";
    } else {
        photoSize = true;
    }
    return photoSize;
});
$('#signature').on('change', function () {

    let size = (this.files[0].size / 1024).toFixed(2);  //Change the file size in byte to
    if (size > 100 || size < 10) {
        if (size > 1024) {
            size = (size / 1024).toFixed(2);
            size = size + " MB";
        } else if (size >= 1 && size < 15) {
            size = size + " KB";
        } else {
            size = (size * 1024).toFixed(2);
            size = size + " Byte";
        }
        signature.setCustomValidity("<br>Signature Size Must Be 10 KB to 100 KB");
        document.getElementById('signatureMsg').innerHTML = "Your Signature Size is:" + size + "<br>Signature Size Must Be 10 KB to 100 KB";
    } else {
        signatureSize = true;
    }
    return signatureSize;
});



//Validation Stop



//Uploading Image Start

$('#uploadPhoto').on('click', function () {
    if (!photoType)
    {
//        This means photo type is not valid
        alert("Photo Must Be In JPG,JPEG or PNG Format");
        photo.setCustomValidity("Photo Must Be In JPG,JPEG or PNG Format");
        document.getElementById('photoMsg').innerHTML = "Photo Must Be In JPG,JPEG or PNG Format";
        return false;

    } else if (!photoSize)
    {
//        This means photo size is not valid
        alert("Photograph Size Must Be 15 KB to 200 KB");
        photo.setCustomValidity("<br>Photograph Size Must Be 15 KB to 200 KB");
        document.getElementById('photoMsg').innerHTML = "Your Photograph Size is:" + size + "<br>Photograph Size Must Be 15 KB to 200 KB";
        return false;
    } else {
        var photo = document.getElementById("photo");
        var fileReader = new FileReader();
        fileReader.readAsDataURL(photo.files[0]);
        fileReader.onloadend = function (event) {
            var showPhoto = document.getElementById("showPhoto");
            showPhoto.src = event.target.result;
        }
    }

});
$('#uploadSign').on('click', function () {
    if (!signatureType)
    {
//        This means signature type is invalid
        alert("Signature Must Be In JPG,JPEG or PNG Format");
        signature.setCustomValidity("Signature Must Be In JPG,JPEG or PNG Format");
        document.getElementById('signatureMsg').innerHTML = "Signature Must Be In JPG,JPEG or PNG Format";
        return false;

    } else if (!signatureSize)
    {
//        This means Signature Size is Invalid
        alert("Signature Size Must Be 10 KB to 100 KB");
        signature.setCustomValidity("<br>Signature Size Must Be 10 KB to 100 KB");
        document.getElementById('signatureMsg').innerHTML = "Your Signature Size is:" + size + "<br>Photograph Size Must Be 10 KB to 100 KB";
    } else {
        var signature = document.getElementById("signature");
        var fileReader = new FileReader();
        fileReader.readAsDataURL(signature.files[0]);
        fileReader.onloadend = function (event) {
            var showSignature = document.getElementById("showSignature");
            showSignature.src = event.target.result;
        }
    }

});




//Uploading Image Stop


//Show Hide  Password Start
$('#showPassword').on('click',function () {
    var password=document.getElementById("password");
    if(password.type=="password")
    {
        password.type="text";
        $('#showPassword').removeClass("fa-eye");
        $('#showPassword').addClass("fa-eye-slash")
    }
    else
    {
        password.type="password";
        
        $('#showPassword').removeClass("fa-eye-slash");
        $('#showPassword').addClass("fa-eye");
    }
});
//Show Hide  Password Sop