package org.comstudy21.ch04.ex04;

class genre{
	private String genre;
	public genre(){
		this("no-genre");
	};
	
	public genre(String genre) {
		this.genre=genre;
	}

	public String getGenre() {
		return genre;
	}


	public void setGenre(String genre) {
		this.genre = genre;
	}
	
	public void showGenre(){
		System.out.println("이 노래의 장르는 "+genre+"입니다.");
	}

	
	
}

class Music {
	private String singer;
	private String song;
	
	public Music(){
		this("no-name","no-song");
	}
	public Music(String singer, String song) {
		this.singer = singer;
		this.song = song;
	}
	public void setSinger(String singer) {
		this.singer = singer;
	}
	public void setSong(String song) {
		this.song = song;
	}
	public void play(){
		System.out.println(singer+"의 "+song+" 실행 중입니다.");
	}
}

class MusicPlayer{
	Music[] arr= new Music[7];
	int i=0;
	public void add(Music music){
		if(i>6) {
			System.out.println("저장용량 초과");
			return;
		}
		arr[i]=music; i++;
	}
	
	public void play(){
		for(int j=0;j<i;j++){
			arr[j].play();
		}
	}
}

//시작이 반이다.
public class Ch10Ex06 {
	public static void main(String[] args) {
		
		Music m1 = new Music("ITZY","wannabe");
		Music m2 = new Music();
		m2.setSinger("투투");
		m2.setSong("1과2분의1");
		Music m3 = new Music("제니","solo");
		
//		m1.play();// ITZY의 wannabe 실행 중입니다.
//		m2.play();// 투투의 1과2분의1  실행 중입니다.		
//		m3.play();// 제니의 solo 실행 중입니다.
		
		MusicPlayer mp = new MusicPlayer();
		//최대 7곡까지 추가 가능
		mp.add(m1);
		mp.add(m2);
		mp.add(m3);
		mp.add(new Music("조용필","바람의 노래"));
		
		mp.play();
		//주말과제 : 전화번호부 구현(클래스를 최대한 많이 만들어서 구현) 계속 업데이트하여 버전 3까지 구현
		
	}

}
