package dto.replydto;
/**
 * @author 서지수
 * @param ReplyDTO 댓글
 */
public class ReplyDTO {
    private int replyNo;
    private String replyWriter;
    private String replyContent;
    private int boardNo;
    private String replyDate;

    public ReplyDTO(){}

    public ReplyDTO(int replyNo, String replyWriter, String replyContent, int boardNo, String replyDate) {
        this.replyNo = replyNo;
        this.replyWriter = replyWriter;
        this.replyContent = replyContent;
        this.boardNo = boardNo;
        this.replyDate = replyDate;
    }

    public int getReplyNo() {
        return replyNo;
    }

    public void setReplyNo(int replyNo) {
        this.replyNo = replyNo;
    }

    public String getReplyWriter() {
        return replyWriter;
    }

    public void setReplyWriter(String replyWriter) {
        this.replyWriter = replyWriter;
    }

    public String getReplyContent() {
        return replyContent;
    }

    public void setReplyContent(String replyContent) {
        this.replyContent = replyContent;
    }

    public int getBoardNo() {
        return boardNo;
    }

    public void setBoardNo(int boardNo) {
        this.boardNo = boardNo;
    }

    public String getReplyDate() {
        return replyDate;
    }

    public void setReplyDate(String replyDate) {
        this.replyDate = replyDate;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("ReplyDTO{");
        sb.append("replyNo=").append(replyNo);
        sb.append(", replyWriter='").append(replyWriter).append('\'');
        sb.append(", replyContent='").append(replyContent).append('\'');
        sb.append(", boardNo=").append(boardNo);
        sb.append(", replyDate='").append(replyDate).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
