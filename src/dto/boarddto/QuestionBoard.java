package dto.boarddto;

public class QuestionBoard extends BoardDTO{
    private boolean isSolved;
    private int selectedReply;

    public QuestionBoard(){}

    public QuestionBoard(int boardNo, String title, String content, String writer, int uuid, String subject, String tag, int likeCnt, int viewCnt, String boardDate, boolean isSolved, int selectedReply) {
        super(boardNo, title, content, writer, uuid, subject, tag, likeCnt, viewCnt, boardDate);
        this.isSolved = isSolved;
        this.selectedReply = selectedReply;
    }

    public boolean isSolved() {
        return isSolved;
    }

    public void setSolved(boolean solved) {
        isSolved = solved;
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
        sb.append("isSolved=").append(isSolved);
        sb.append(", selectedReply=").append(selectedReply);
        return sb.toString();
    }
}
