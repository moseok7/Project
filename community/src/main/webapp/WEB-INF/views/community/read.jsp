<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="../include/header.jspf"%>

<body id="body">

	<section class="signin-page account">
		<div class="container">
			<div class="row">
				<div class="box-header">
					<h3 class="box-title">READ BOARD</h3>
				</div>

				<form role="form" method="post">

					<input type='hidden' name='cNo' value="${CommunityVO.cNo}">



					<div class="form-group">
						<label for="mId">Writer</label> <input type="text" name='mId'
							class="form-control" value="${CommunityVO.mId}"
							readonly="readonly">
					</div>

					<div class="form-group">
						<label for="title">Title</label> <input type="text" name='title'
							class="form-control" value="${CommunityVO.title}"
							readonly="readonly">
					</div>

					<div class="form-group">
						<label for="content">Content</label>
						<textarea class="form-control" name="content" rows="7"
							readonly="readonly">${CommunityVO.content}</textarea>
					</div>

					<div class="box-footer">
						<button type="submit" class="btn btn-main" id="update">Modify</button>
						<button type="submit" class="btn btn-main" id="delete">REMOVE</button>
						<button type="submit" class="btn btn-main" id="list">LIST
							ALL</button>
					</div>
				</form>
				<script>
					$(document).ready(function() {

						var formObj = $("form[role='form']");

						console.log(formObj);

						$(".btn-main").on("click", function() {
							formObj.attr("action", "/board/update");
							formObj.attr("method", "get");
							formObj.submit();
						});

						/* $(".btn btn-main1").on("click", function() {
							formObj.attr("action", "/board/remove");
							formObj.submit();
						});

						$(".btn btn-main2").on("click", function() {
							self.location = "/board/list";
						}); */

					});
				</script>
				<!-- <div class="text-center">
								<button type="submit" class="btn btn-main text-center">Modify
									</button>
							</div> -->
				<!-- <p class="mt-20">
							Already hava an account ?<a href="login.html"> Login</a>
						</p>
						<p>
							<a href="forget-password.html"> Forgot your password?</a>
						</p> -->
			</div>
		</div>
	</section>
</body>

<%@ include file="../include/footer.jspf"%>