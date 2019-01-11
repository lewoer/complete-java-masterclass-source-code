package com.shile;

/**
 * @Author: ShiLe
 * @Description: local class,匿名类也是local class只是没有名字
 * @Date: Created in 16:11 2018/12/15
 */
public class Button {
    private String title;
    private OnClickListener onClickListener;

    public Button(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setOnClickListener(OnClickListener onClickListener) {
        this.onClickListener = onClickListener;
    }

    public void OnClick() {
        this.onClickListener.onClick(this.title);
    }

    public interface OnClickListener {
        void onClick(String title);
    }



}
