package dto.replydto;

public class QuestionReply extends ReplyDTO{
	private int selectedReply;

	public QuestionReply(int selectedReply) {
		super();
		this.selectedReply = selectedReply;
	}

	public QuestionReply() {
		super();
		// TODO Auto-generated constructor stub
	}

	public QuestionReply(int replyNo, String replyWriter, String replyContent, int boardNo, String replyDate) {
		super(replyNo, replyWriter, replyContent, boardNo, replyDate);
		// TODO Auto-generated constructor stub
	}

	public int getSelectedReply() {
		return selectedReply;
	}

	public void setSelectedReply(int selectedReply) {
		this.selectedReply = selectedReply;
	}

	@Override
	public String toString() {
		 final StringBuilder sb = new StringBuilder(super.toString());
	        sb.append("selectedReply=").append(selectedReply);
	        return sb.toString();
	}
	
	
}
