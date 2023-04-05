package dto.boarddto;

public class BoardDTO {
	private int boardNo;
	private String title;
	private String content;
	private String writer;
	private int uuid;
	private String subject;
	private String tag;
	private int likeCnt; // Like Table 생기면 삭제
	private int viewCnt;
	private String boardDate;

	public BoardDTO() {
	}

	public BoardDTO(String title, String content, String writer, int uuid, String subject) {
		this.title = title;
		this.content = content;
		this.writer = writer;
		this.uuid = uuid;
		this.subject = subject;
	}

	public BoardDTO(int boardNo, String title, String content, String writer, int uuid, String subject, String tag,
			int likeCnt, int viewCnt, String boardDate) {
		this(title, content, writer, uuid, subject);
		this.boardNo = boardNo;
		this.tag = tag;
		this.likeCnt = likeCnt;
		this.viewCnt = viewCnt;
		this.boardDate = boardDate;
	}

	public int getBoardNo() {
		return boardNo;
	}

	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public int getUuid() {
		return uuid;
	}

	public void setUuid(int uuid) {
		this.uuid = uuid;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public int getLikeCnt() {
		return likeCnt;
	}

	public void setLikeCnt(int likeCnt) {
		this.likeCnt = likeCnt;
	}

	public int getViewCnt() {
		return viewCnt;
	}

	public void setViewCnt(int viewCnt) {
		this.viewCnt = viewCnt;
	}

	public String getBoardDate() {
		return boardDate;
	}

	public void setBoardDate(String boardDate) {
		this.boardDate = boardDate;
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder();
		sb.append("boardNo=").append(boardNo);
		sb.append(", title='").append(title).append(" | ");
		sb.append(", content='").append(content).append(" | ");
		sb.append(", writer='").append(writer).append(" | ");
		sb.append(", uuid=").append(uuid);
		sb.append(", subject='").append(subject).append(" | ");
		sb.append(", tag='").append(tag).append(" | ");
		sb.append(", likeCnt=").append(likeCnt);
		sb.append(", viewCnt=").append(viewCnt);
		sb.append(", boardDate='").append(boardDate).append(" | ");
		return sb.toString();
	}
}
