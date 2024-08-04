<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>채팅방</title>

<style>
/*전체 크기 늘리기  */
.content{
	padding:80px 0 0 0;
	overflow: visible;
    position: relative; /* 자식 div의 절대 위치 기준을 설정 */
}

.total-content{
	width: 100%;  /* section의 전체 너비 */
    height: 100%; /* section의 전체 높이 */
    box-sizing: border-box; /* 패딩과 테두리의 크기를 포함하여 총 크기를 계산 */
    margin:0px 30px;
    max-width: 100%; /* 부모 요소나 뷰포트의 최대 너비를 설정 */
}
.grid-rows{
	display:grid;
	grid-template-columns: 1fr 1.5fr;
	gap: 10px; /* 열 사이의 간격 */
    width: 100vw;  /* 뷰포트 너비의 100% */
    height: 100vh; /* 뷰포트 높이의 100% */
    box-sizing: border-box; /* 패딩과 보더를 포함하여 크기를 계산 */
    overflow: hidden; /* 넘치는 내용을 숨김 */

}


.add-margin{
	margin: 16px 0px 16px;

}


       .icon-wrapper {
            display: flex;
            align-items: center; /* 아이콘을 중앙 정렬 */
            height: 100%; /* 아이콘의 높이를 100%로 설정 */
            margin-left: 5px; /* 아이콘과 입력 필드 사이의 간격 */
        }

.scrollable-div{
			width: 380px; /* 너비 설정 */
            height: 650px; /* 높이 설정 */
            border: 1px solid #ccc; /* 테두리 설정 */
            overflow: auto; /* 스크롤을 자동으로 추가 */
}

.resize-col1{
width:100%;
height:100%;
}


.resize-col2{
width:100%;
}

.search-div{

}

.card-size{

}

/*card-body div 태그 밑으로 내리기  */
.down-card{
	

}


a.custom{
	 text-decoration: none !important;
}
</style>

<!-- Font Awesome -->
<link
  href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css"
  rel="stylesheet"
/>
<!-- Google Fonts -->
<link
  href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700&display=swap"
  rel="stylesheet"
/>
<!-- MDB -->
<link
  href="https://cdnjs.cloudflare.com/ajax/libs/mdb-ui-kit/7.3.2/mdb.min.css"
  rel="stylesheet"
/>
	<!-- MDB -->
</head>
<body>
	<!-- 메뉴바 연결 -->
	<%@ include file="../common/header.jsp"%>
	<section class="content">
		<div class=" total-content py-5">

			<div class="grid-rows">
				<div class="d-flex align-items-start justify-content-center">
				<div class="col-xl-6 mb-4 mb-md-0">
				
					<select class="form-select" aria-label="Default select example">
					  <option selected>Open this select menu</option>
					  <option value="1">One</option>
					  <option value="2">Two</option>
					  <option value="3">Three</option>
					</select>
					
					<div class="d-flex align-items-center">
					  <input type="text" class="add-margin form-control" placeholder="학생 이름을 검색해주세요." aria-label="Sizing example input" aria-describedby="inputGroup-sizing-default">
						<div class="icon-wrapper">
							<svg xmlns="http://www.w3.org/2000/svg" width="100%" height="100%" fill="currentColor" class="add-margin mh-100 w-25 bi bi-search" viewBox="0 0 16 16">
							  <path d="M11.742 10.344a6.5 6.5 0 1 0-1.397 1.398h-.001q.044.06.098.115l3.85 3.85a1 1 0 0 0 1.415-1.414l-3.85-3.85a1 1 0 0 0-.115-.1zM12 6.5a5.5 5.5 0 1 1-11 0 5.5 5.5 0 0 1 11 0"/>
							</svg>
						</div>
					</div>
					
					<div class="card-size card">
						<div class="down-card card-body scrollable-div">

							<ul class="list-unstyled mb-0">
								<li class="p-2 border-bottom bg-body-tertiary"><a href="#!"
									class="custom d-flex justify-content-between">
										<div class="d-flex flex-row">
											<img
												src="https://mdbcdn.b-cdn.net/img/Photos/Avatars/avatar-8.webp"
												alt="avatar"
												class="rounded-circle d-flex align-self-center me-3 shadow-1-strong"
												width="60">
											<div class="pt-1">
												<p class="fw-bold mb-0">John Doe</p>
												<p class="d-inline-block text-truncate small text-muted" style="max-width: 150px;">Hello, Are you there?????????????</p>
											</div>
										</div>
										<div class="pt-1">
											<p class="small text-muted mb-1">Just now</p>
											<span class="badge bg-danger float-end">1</span>
										</div>
								</a></li>
								<li class="p-2 border-bottom"><a href="#!"
									class="custom d-flex justify-content-between">
										<div class="d-flex flex-row">
											<img
												src="https://mdbcdn.b-cdn.net/img/Photos/Avatars/avatar-1.webp"
												alt="avatar"
												class="rounded-circle d-flex align-self-center me-3 shadow-1-strong"
												width="60">
											<div class="pt-1">
												<p class="fw-bold mb-0">Danny Smith</p>
												<p class="small text-muted">Lorem ipsum dolor sit.</p>
											</div>
										</div>
										<div class="pt-1">
											<p class="small text-muted mb-1">5 mins ago</p>
										</div>
								</a></li>
								<li class="p-2 border-bottom"><a href="#!"
									class="custom d-flex justify-content-between">
										<div class="d-flex flex-row">
											<img
												src="https://mdbcdn.b-cdn.net/img/Photos/Avatars/avatar-2.webp"
												alt="avatar"
												class="rounded-circle d-flex align-self-center me-3 shadow-1-strong"
												width="60">
											<div class="pt-1">
												<p class="fw-bold mb-0">Alex Steward</p>
												<p class="small text-muted">Lorem ipsum dolor sit.</p>
											</div>
										</div>
										<div class="pt-1">
											<p class="small text-muted mb-1">Yesterday</p>
										</div>
								</a></li>
								<li class="p-2 border-bottom"><a href="#!"
									class="custom d-flex justify-content-between">
										<div class="d-flex flex-row">
											<img
												src="https://mdbcdn.b-cdn.net/img/Photos/Avatars/avatar-3.webp"
												alt="avatar"
												class="rounded-circle d-flex align-self-center me-3 shadow-1-strong"
												width="60">
											<div class="pt-1">
												<p class="fw-bold mb-0">Ashley Olsen</p>
												<p class="small text-muted">Lorem ipsum dolor sit.</p>
											</div>
										</div>
										<div class="pt-1">
											<p class="small text-muted mb-1">Yesterday</p>
										</div>
								</a></li>
								<li class="p-2 border-bottom"><a href="#!"
									class="custom d-flex justify-content-between">
										<div class="d-flex flex-row">
											<img
												src="https://mdbcdn.b-cdn.net/img/Photos/Avatars/avatar-4.webp"
												alt="avatar"
												class="rounded-circle d-flex align-self-center me-3 shadow-1-strong"
												width="60">
											<div class="pt-1">
												<p class="fw-bold mb-0">Kate Moss</p>
												<p class="small text-muted">Lorem ipsum dolor sit.</p>
											</div>
										</div>
										<div class="pt-1">
											<p class="small text-muted mb-1">Yesterday</p>
										</div>
								</a></li>
								<li class="p-2 border-bottom"><a href="#!"
									class="custom d-flex justify-content-between">
										<div class="d-flex flex-row">
											<img
												src="https://mdbcdn.b-cdn.net/img/Photos/Avatars/avatar-5.webp"
												alt="avatar"
												class="rounded-circle d-flex align-self-center me-3 shadow-1-strong"
												width="60">
											<div class="pt-1">
												<p class="fw-bold mb-0">Lara Croft</p>
												<p class="small text-muted">Lorem ipsum dolor sit.</p>
											</div>
										</div>
										<div class="pt-1">
											<p class="small text-muted mb-1">Yesterday</p>
										</div>
								</a></li>
								<li class="p-2"><a href="#!"
									class="custom d-flex justify-content-between">
										<div class="d-flex flex-row">
											<img
												src="https://mdbcdn.b-cdn.net/img/Photos/Avatars/avatar-6.webp"
												alt="avatar"
												class="rounded-circle d-flex align-self-center me-3 shadow-1-strong"
												width="60">
											<div class="pt-1">
												<p class="fw-bold mb-0">Brad Pitt</p>
												<p class="small text-muted">Lorem ipsum dolor sit.</p>
											</div>
										</div>
										<div class="pt-1">
											<p class="small text-muted mb-1">5 mins ago</p>
											<span class="text-muted float-end"><i
												class="fas fa-check" aria-hidden="true"></i></span>
										</div>
								</a></li>
								<li class="p-2"><a href="#!"
									class="custom d-flex justify-content-between">
										<div class="d-flex flex-row">
											<img
												src="https://mdbcdn.b-cdn.net/img/Photos/Avatars/avatar-6.webp"
												alt="avatar"
												class="rounded-circle d-flex align-self-center me-3 shadow-1-strong"
												width="60">
											<div class="pt-1">
												<p class="fw-bold mb-0">Brad Pitt</p>
												<p class="small text-muted">Lorem ipsum dolor sit.</p>
											</div>
										</div>
										<div class="pt-1">
											<p class="small text-muted mb-1">5 mins ago</p>
											<span class="text-muted float-end"><i
												class="fas fa-check" aria-hidden="true"></i></span>
										</div>
								</a></li>
							</ul>

						</div>
					</div>

				</div>
				</div>

				<div class="resize-col2 col-md-6 col-lg-7 col-xl-8">

					<ul class="list-unstyled">
						<li class="d-flex justify-content-between mb-6"><img
							src="https://mdbcdn.b-cdn.net/img/Photos/Avatars/avatar-6.webp"
							alt="avatar"
							class="rounded-circle d-flex align-self-start me-3 shadow-1-strong"
							width="60">
							<div class="card">
								<div class="card-header d-flex justify-content-between p-3">
									<p class="fw-bold mb-0">Brad Pitt</p>
									<p class="text-muted small mb-0">
										<i class="far fa-clock"></i> 12 mins ago
									</p>
								</div>
								<div class="card-body">
									<p class="mb-0">Lorem ipsum dolor sit amet, consectetur
										adipiscing elit, sed do eiusmod tempor incididunt ut labore et
										dolore magna aliqua.</p>
								</div>
							</div></li>
						<li class="d-flex justify-content-between mb-6">
							<div class="card w-100">
								<div class="card-header d-flex justify-content-between p-3">
									<p class="fw-bold mb-0">Lara Croft</p>
									<p class="text-muted small mb-0">
										<i class="far fa-clock"></i> 13 mins ago
									</p>
								</div>
								<div class="card-body">
									<p class="mb-0">Sed ut perspiciatis unde omnis iste natus
										error sit voluptatem accusantium doloremque laudantium.</p>
								</div>
							</div> <img
							src="https://mdbcdn.b-cdn.net/img/Photos/Avatars/avatar-5.webp"
							alt="avatar"
							class="rounded-circle d-flex align-self-start ms-3 shadow-1-strong"
							width="60">
						</li>
						<li class="d-flex justify-content-between mb-6"><img
							src="https://mdbcdn.b-cdn.net/img/Photos/Avatars/avatar-6.webp"
							alt="avatar"
							class="rounded-circle d-flex align-self-start me-3 shadow-1-strong"
							width="60">
							<div class="card">
								<div class="card-header d-flex justify-content-between p-3">
									<p class="fw-bold mb-0">Brad Pitt</p>
									<p class="text-muted small mb-0">
										<i class="far fa-clock"></i> 10 mins ago
									</p>
								</div>
								<div class="card-body">
									<p class="mb-0">Lorem ipsum dolor sit amet, consectetur
										adipiscing elit, sed do eiusmod tempor incididunt ut labore et
										dolore magna aliqua.</p>
								</div>
							</div></li>
						<li class="bg-white mb-3">
							<div data-mdb-input-init class="form-outline">
								<textarea class="form-control bg-body-tertiary"
									id="textAreaExample2" rows="4"></textarea>
								<label class="form-label" for="textAreaExample2">Message</label>
							</div>
						</li>
						<button type="button" data-mdb-button-init data-mdb-ripple-init
							class="btn btn-info btn-rounded float-end">Send</button>
					</ul>

				</div>

			</div>

		</div>
	</section>
	<!-- 푸터 연결 -->
	<%@ include file="../common/footer.jsp"%>
	
	
<script
  type="text/javascript"
  src="https://cdnjs.cloudflare.com/ajax/libs/mdb-ui-kit/7.3.2/mdb.umd.min.js"
></script>	

</body>
</html>