    function updateMember(memberNo) {
        
        let updatedMemberName = "";
        let updatedGradeName = "";

        updatedMemberName = prompt("수정할 회원 이름을 입력하세요:", "");
        updatedGradeName = prompt("수정할 회원 등급을 입력하세요:", "");

        console.log(memberNo);
        console.log(updatedMemberName);
        console.log(updatedGradeName);
        
        const params = new URLSearchParams();
        params.append("memberNo", memberNo);
        params.append("updatedMemberName", updatedMemberName);
        params.append("updatedGradeName", updatedGradeName);

        location.href = "/MM/update?" + params.toString();
    }

    function asc(columnName){
        location.href = "/?asc=" + columnName; 

    }

    function desc(columnName){
        location.href = "/?desc=" + columnName; 

    }