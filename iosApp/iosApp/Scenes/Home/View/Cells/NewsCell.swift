//
//  NewsCell.swift
//  iosApp
//
//  Created by talgar osmonov on 24/5/21.
//  Copyright © 2021 orgName. All rights reserved.
//

import SnapKit
import UIKit
import shared
import Kingfisher


final class NewsCell: UITableViewCell {
    
    // MARK: - Views
    
    private lazy var newsImageView: UIImageView = {
       let imageView = UIImageView()
        imageView.contentMode = .scaleAspectFill
        imageView.clipsToBounds = true
        return imageView
    }()
    
    private lazy var titeLabel: UILabel = {
       let label = UILabel()
        label.textColor = .white
        label.font = UIFont.systemFont(ofSize: 18, weight: .bold)
        label.numberOfLines = 0
        label.sizeToFit()
        return label
    }()
    
    private lazy var descriptionLabel: UILabel = {
       let label = UILabel()
        label.textColor = .white
        label.font = UIFont.systemFont(ofSize: 16, weight: .regular)
        label.numberOfLines = 0
        label.sizeToFit()
        return label
    }()
    
    //
    
    // MARK: - Init
    
    override init(style: UITableViewCell.CellStyle, reuseIdentifier: String?) {
        super.init(style: style, reuseIdentifier: reuseIdentifier)
        configure()
    }
    
    required init?(coder: NSCoder) {
        fatalError("init(coder:) has not been implemented")
    }
    
    // MARK: - Private Methods
    
    private func configure() {
        backgroundColor = .white
        addSubviews()
        addConstraints()
    }
    
    private func addSubviews() {
        addSubview(newsImageView)
        addSubview(descriptionLabel)
        addSubview(titeLabel)
        
    }
    
    private func addConstraints() {
        newsImageView.snp.makeConstraints { make in
            make.edges.equalToSuperview()
        }
        descriptionLabel.snp.makeConstraints { make in
            make.bottom.equalToSuperview().inset(13)
            make.leading.trailing.equalToSuperview().inset(20)
            make.height.equalTo(60)
        }
        titeLabel.snp.makeConstraints { make in
            make.bottom.equalTo(descriptionLabel.snp.top).offset(-6)
            make.leading.trailing.equalToSuperview().inset(20)
        }
        
    }
    
    // MARK: - Helpers
    
    func setupData(data: Article) {
        if let imageUrl = data.urlToImage {
            newsImageView.kf.setImage(with: URL(string: imageUrl))
        }
        descriptionLabel.text = data.description()
        titeLabel.text = data.title
    }
}

