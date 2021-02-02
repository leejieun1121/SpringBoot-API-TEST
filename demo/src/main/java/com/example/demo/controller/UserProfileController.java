package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.mapper.UserProfileMapper;
import com.example.demo.model.UserProfile;


//컨트롤러 인식 
@RestController
public class UserProfileController {
	
//	private Map<String, UserProfile> userMap;
	
	private UserProfileMapper mapper;
	public UserProfileController(UserProfileMapper mapper) {
		this.mapper = mapper;
	}
//	//데이터 초기화 
//	@PostConstruct
//	public void init() {
//		userMap = new HashMap<String, UserProfile>();
//		userMap.put("1", new UserProfile("1", "홍길동", "111-1111", "서울시 강남구 대치1동"));
//		userMap.put("2", new UserProfile("2", "홍길돈", "111-1112", "서울시 강남구 대치2동"));
//		userMap.put("3", new UserProfile("3", "홍길독", "111-1113", "서울시 강남구 대치3동"));
//	}
	
	//{}안의 부분을 PathVariable로 인식하고 id로 넘겨 호출하게 됨 
	@GetMapping("/user/{id}")
	public UserProfile getUserProfile(@PathVariable("id") String id) {
		//객체만 넘겨줘도 알아서 json으로 넘겨줌 
//		return userMap.get(id);
		return mapper.getUserProfile(id);
		
	}
	
	@GetMapping("/user/all")
	public List<UserProfile> getUserProfileList(){
		//usermap이 가지고 있는 value들을 arraylist로 바꿔 리턴 
//		return new ArrayList<UserProfile>(userMap.values());
		return mapper.getUserProfileList();
	}
	
	//Path를 통해 전달할 수 있지만, path는 간단한1,2가지 정도의 파라미터 전달 시 사용
	//일반적으로는 RequestParam을 사용함 
	@PostMapping("/user/{id}")
	public void postUserProfile(@PathVariable("id") String id, @RequestParam("name") String name, @RequestParam("phone") String phone, @RequestParam(value = "address", required=false) String address) {
		//ㅡㅡ 왜 똑같이 쳤는데 address부분에서 오류가 나는지 전혀 모르겠다 ㅠ
		//구글링했더니 required = false 를 해주면 예외처리를 알아서 null로 해주는 것 같다.
//		UserProfile userProfile = new UserProfile(id, name, phone, address);
//		userMap.put(id, userProfile); 
		mapper.insertUserProfile(id, name, phone, address);
	}
	
	@PutMapping("/user/{id}")
	public void putUserProfile(@PathVariable("id") String id, @RequestParam("name") String name, @RequestParam("phone") String phone, @RequestParam(value = "address", required=false) String address) {
//		UserProfile userProfile = userMap.get(id);
//		userProfile.setName(name);
//		userProfile.setPhone(phone);
//		userProfile.setAddress(address);
		mapper.updateUserProfile(id, name, phone, address);
	}
	
	@DeleteMapping("/user/{id}")
	public void deleteUserProfile(@PathVariable("id") String id) {
//		userMap.remove(id);
		mapper.deleteUserProfile(id);
	}
	//조회 -> 주로 Get, GetMapping 
	//수정 -> Post
	//생성 ->Put
	//삭제 -> Delete 
	
	

}
