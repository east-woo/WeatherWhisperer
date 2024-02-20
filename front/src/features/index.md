./src/features
├── auth
│   ├── authApiSlice.ts
│   └── userApiSlice.ts
└──bookmarks
├── services
│   ├── bookmarkSlice.ts
│   ├── bookmarkEventApiSlice.ts
│   ├── bookmarkFolderApiSlice.ts
│   └── bookmarkFolderSlice.ts
└── modals
├── BookmarkFolderModal.tsx
├── BookmarkFolderStyle.tsx
├── BookmarkModal.tsx
└── BookmarkModalStyle.tsx
프로젝트에 필요한 재사용 컴포넌트 및 queries를 기능별로 분류하여 정리한 폴더입니다. 기능별로 파일을 쉽게 찾을 수 있고, 파일의 용도를 파악하기에 좋습니다.

src/components에 존재하는 재사용 컴포넌트는 컴포넌트 전반에서 재사용되는 경우라면, src/features 에 존재하는 재사용 컴포넌트는 특정 기능에 한해서만 재사용됩니다. 예를들어서 CommonModal.tsx는 모든 모달의 뼈대가 되는 컴포넌트라면, BookmarkModal.tsx는  북마크 기능만을 수행하는 모달입니다.

상태관리툴로 Redux-toolkit과 RTK-Query를 사용했는데, 이에 관련된 api, query/mutation 들은 기능별로 분류하여  services 하위폴더에 위치시켰습니다. 

 