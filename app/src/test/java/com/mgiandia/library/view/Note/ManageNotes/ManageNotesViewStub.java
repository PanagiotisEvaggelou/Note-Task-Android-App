package com.mgiandia.library.view.Note.ManageNotes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.mgiandia.library.util.Quadruple;



public class ManageNotesViewStub implements ManageNotesView
{
    private Map<Integer, Integer> clicksCount, listClicksCount;
    private List<Quadruple> setSource;
    private String toastShown, pageName;
    private Integer attachedAuthorID, attachedPublisherID;
    private boolean shouldLoadItemsOnClick, addedNew;

    ManageNotesViewStub()
    {
        clicksCount = new HashMap<Integer, Integer>();
        listClicksCount = new HashMap<Integer, Integer>();
        addedNew = false;
        setSource = new ArrayList<Quadruple>();
        toastShown = "";
    }

    @Override
    public void clickItem(int uid)
    {
        clicksCount.put(uid, (clicksCount.containsKey(uid) ? clicksCount.get(uid) : 0)+1);
    }

    @Override
    public void clickItemList(int uid)
    {
        listClicksCount.put(uid, (listClicksCount.containsKey(uid) ? listClicksCount.get(uid) : 0)+1);
    }

    @Override
    public void startAddNew()
    {
        addedNew = true;
    }

    @Override
    public void loadSource(List<Quadruple> input)
    {
        setSource = input;
    }

    public String getPageName()
    {
        return pageName;
    }

    @Override
    public void setPageName(String value) {
        pageName = value;
    }

    @Override
    public void showToast(String value)
    {
        toastShown = value;
    }

    public void setShouldLoadItemsOnClick(boolean val) {
        shouldLoadItemsOnClick = val;
    }

    @Override
    public boolean shouldLoadItemsOnClick() {
        return shouldLoadItemsOnClick;
    }

    public void setAttachedAuthorID(Integer val) {
        attachedAuthorID = val;
    }

    public void setAttachedPublisherID(Integer val) {
        attachedPublisherID = val;
    }

    @Override
    public Integer getAttachedAuthorID() {
        return attachedAuthorID;
    }

    @Override
    public Integer getAttachedPublisherID() {
        return attachedPublisherID;
    }

    public boolean isNewAdded()
    {
        return addedNew;
    }

    public List<Quadruple> getSource()
    {
        return setSource;
    }

    public int getTimesListClickedItem(int uid)
    {
        return listClicksCount.containsKey(uid) ? listClicksCount.get(uid) : 0;
    }

    public int getTimesClickedItem(int uid)
    {
        return clicksCount.containsKey(uid) ? clicksCount.get(uid) : 0;
    }

    public String getToast()
    {
        return toastShown;
    }
}
