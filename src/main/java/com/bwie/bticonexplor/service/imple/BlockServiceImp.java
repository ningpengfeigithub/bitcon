package com.bwie.bticonexplor.service.imple;

import com.bwie.bticonexplor.dao.BlockMapper;
import com.bwie.bticonexplor.dto.BlockListDto ;
import com.bwie.bticonexplor.po.Block;
import com.bwie.bticonexplor.service.BlockService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class BlockServiceImp implements BlockService {

    @Autowired
    private BlockMapper blockMapper;

    ArrayList<BlockListDto> BlockListDto=new ArrayList<>();


    @Override
    public List<BlockListDto> getrecentblock() {
        List<Block> blocks = blockMapper.selectRecentBlocks();

        for (Block block : blocks) {
            BlockListDto blockListDTO = new BlockListDto();
            blockListDTO.setBlockhash(block.getBlockhash());
            blockListDTO.setHeight(block.getHeight());
            blockListDTO.setTime(block.getTime().getTime());
            blockListDTO.setTxsize(block.getTxsize());
            blockListDTO.setSize(block.getSize());
            BlockListDto.add(blockListDTO);
        }

        return BlockListDto;
    }
}
