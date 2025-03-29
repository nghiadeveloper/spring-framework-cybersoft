// $(document).ready(): Khi nào trang account.html được load ra giao diện thành công trên trình duyệt web 
// thì dev sẽ bắt đầu xử lý logic code cho trang account.html
$(document).ready(function() {

    // Xử lý logic code ở đây
    $('#btn-login').click(function() {
        // Lấy giá trị người dùng nhập vào ở thẻ input
        var email = $('#login-email').val()
        var password = $('#login-password').val()

        // ajax: cho phép mình gọi 1 cái đường dẫn nào đó, mà mình muốn lấy kết quả của đường dẫn đó
        $.ajax({
            method: "POST",
            url: "http://localhost:8080/auth/sign-in",
            data: { 
                email: email, 
                password: password 
            }
        }).done(function (result) {
            console.log(result.data)
            if(result.data) {
                alert('Đăng nhập thành công!')
            } else {
                alert('Đăng nhập thất bại!')
            }
        });
    })

})