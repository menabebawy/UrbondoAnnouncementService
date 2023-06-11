package com.urbondo.announcement.service.service;

import org.springframework.stereotype.Service;

@Service
public class AnnouncementServiceImpl implements AnnouncementService {
//    private final AnnouncementRepository announcementRepository;
//    private final CategoryRepository categoryRepository;
//
//    public AnnouncementServiceImpl(AnnouncementRepository announcementRepository,
//                                   CategoryRepository categoryRepository) {
//        this.announcementRepository = announcementRepository;
//        this.categoryRepository = categoryRepository;
//    }
//
//    @Override
//    public AnnouncementDTO findById(String id) {
//        return announcementRepository.findById(id)
//                .map(Mapper::transferTo)
//                .orElseThrow(() -> new AnnouncementNotFoundException(id));
//    }
//
//    @Override
//    public AddAnnouncementResponseDTO add(final AddAnnouncementRequestDTO requestDTO) {
//        Optional<CategoryDAO> categoryEntity = categoryRepository.findById(requestDTO.categoryId());
//
//        if (categoryEntity.isEmpty()) {
//            throw new CategoryNotFoundException(requestDTO.categoryId());
//        }
//
//        AnnouncementEntity announcementEntity
//                = announcementRepository.save(requestDTO.transferTo(requestDTO.categoryId()));
//        return new AddAnnouncementResponseDTO(announcementEntity.getId());
//    }
//
//    @Override
//    public AnnouncementDTO update(UpdateAnnouncementRequestDTO requestDTO) {
//        AnnouncementDTO announcementDTO = findById(requestDTO.id());
//        announcementRepository.save(Mapper.transferTo(announcementDTO));
//        return announcementDTO;
//    }
//
//    @Override
//    public void deleteById(String id) {
//        findById(id);
//        announcementRepository.deleteById(id);
//    }
}
