### JMemo: 이미지 첨부 기능과 YouTube 동영상 첨부 기능을 가진 메모장 어플리케이션

#### Android

	- minSdkVersion: 21
	- targetSdkVersion: 27 이상

#### 사용언어

- Kotlin

#### 기능1 :  메모리스트

- 로컬 영역에 저장된 메모를 읽어 리스트 형태로 화면에 표시합니다.

- 리스트에는 메모에 첨부되어있는 이미지 또는 영상의 썸네일, 제목, 글의 일부가 보여집니다.

  (이미지가 n개일 경우, 첫 번째 이미지가 썸네일이 됩니다.)

- 리스트의 메모를 선택하면 메모 상세 보기화면으로 이동합니다.

- 새 메모 작성하기 기능을 통해 메모 작성 화면으로 이동할 수 있습니다.

#### 기능2 : 메모 상세 보기

- 작성된 메모의 제목과 본문을 볼 수 있습니다.
- 메모에 첨부되어있는 이미지 또는 YouTube 영상을 볼 수 있습니다. (이미지는 n개, 동영상은 1개 저장 가능)
- 메뉴를 통해 메모 내용 편집 또는 삭제가 가능합니다.

#### 기능3 : 메모 편집 및 작성

- YouTube 영상 메모와 일반 메모 추가버튼이 구분되어 있습니다.

- 제목 입력란과 본문 입력란, 이미지 첨부란이 구분되어 있습니다.
- 이미지는 3가지 경우를 첨부할 수 있습니다.
  - 사진첩에 저장되어 있는 이미지
  - 카메라로 새로 촬영한 이미지
  - 외부 이미지 주소(URL) - (YouTube 또는 Instagram 주소를 입력시 썸네일을 가져옵니다.)
- 동영상은 YouTube URL만을 첨부할 수 있습니다.
- 편집 시에는 기존에 첨부된 이미지가 나타나며, 이미지를 더 추가하거나 기존 이미지를 삭제할 수 있습니다.