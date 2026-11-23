package sk.lukasdancak.treekey.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class TreeCommentForm {

    @NotBlank(message = "Comment cannot be empty.")
    @Size(max = 2000, message = "Comment must be 2000 characters or fewer.")
    private String content;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
