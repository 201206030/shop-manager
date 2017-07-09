package net.happyshop.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import net.happyshop.mapper.TbItemMapper;
import net.happyshop.pojo.EasyUiDataGridResult;
import net.happyshop.pojo.TbItem;
import net.happyshop.pojo.TbItemExample;
import net.happyshop.pojo.TbItemExample.Criteria;
import net.happyshop.service.ItemService;

@Service
public class ItemServiceImp implements ItemService{
    
    @Autowired
    private TbItemMapper itemMapper;

    @Override
    public TbItem getItemById(long id) {
        TbItemExample example = new TbItemExample();
        Criteria criteria = example.createCriteria();
        criteria.andIdEqualTo(id);
        List<TbItem> items = itemMapper.selectByExample(example);
        if ((items != null) && (items.size() > 0)) {
            return items.get(0);
        }
        return null;
    }

    @Override
    public EasyUiDataGridResult<TbItem> getItemList(int pageNum, int pageSize) {
        PageHelper helper = new PageHelper();
        helper.startPage(pageNum, pageSize);
        TbItemExample example = new TbItemExample();
        List<TbItem> itemList = itemMapper.selectByExample(example);
        PageInfo info = new PageInfo(itemList);
        EasyUiDataGridResult<TbItem> result = new EasyUiDataGridResult<TbItem>();
        result.setTotal(info.getTotal());
        result.setRows(itemList);
        return result;
    }
    
}
